/*
 * Copyright 2019 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.professions.bukkit.listener

import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.core.bukkit.util.addLore
import com.rpkit.itemquality.bukkit.itemquality.RPKItemQuality
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.professions.bukkit.RPKProfessionsBukkit
import com.rpkit.professions.bukkit.profession.RPKCraftingAction
import com.rpkit.professions.bukkit.profession.RPKProfessionProvider
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.inventory.ItemStack
import kotlin.math.roundToInt
import kotlin.random.Random


class CraftItemListener(private val plugin: RPKProfessionsBukkit): Listener {

    @EventHandler
    fun onCraftItem(event: CraftItemEvent) {
        val bukkitPlayer = event.whoClicked
        if (bukkitPlayer is Player) {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
            val professionProvider = plugin.core.serviceManager.getServiceProvider(RPKProfessionProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(bukkitPlayer)
            if (minecraftProfile == null) {
                event.isCancelled = true
                bukkitPlayer.sendMessage(plugin.messages["no-minecraft-profile"])
                return
            }
            val character = characterProvider.getActiveCharacter(minecraftProfile)
            if (character == null) {
                event.isCancelled = true
                bukkitPlayer.sendMessage(plugin.messages["no-character"])
                return
            }
            val itemType = event.recipe.result.type
            val professions = professionProvider.getProfessions(character)
            val professionLevels = professions
                    .associateWith { profession -> professionProvider.getProfessionLevel(character, profession) }
            var amountCrafted = getAmountCrafted(event)
            val amount = professionLevels.entries
                    .map { (profession, level) -> profession.getAmountFor(RPKCraftingAction.CRAFT, itemType, level) }
                    .firstOrNull() ?: plugin.config.getDouble("default.crafting.$itemType.amount", 1.0)
            val potentialQualities = professionLevels.entries
                    .mapNotNull { (profession, level) -> profession.getQualityFor(RPKCraftingAction.CRAFT, itemType, level) }
            val quality = potentialQualities.maxBy(RPKItemQuality::durabilityModifier)
            if (amount > 1) {
                amountCrafted *= amount.roundToInt()
            } else if (amount < 1) {
                amountCrafted = (amountCrafted * amount).roundToInt()
                if (amountCrafted == 0) {
                    if (Random.nextDouble() <= amount) {
                        amountCrafted = 1
                    }
                }
            }
            val item = ItemStack(event.recipe.result)
            item.amount = amountCrafted
            if (quality != null) {
                item.addLore(quality.lore)
            }
            event.isCancelled = true
            if (event.isShiftClick) {
                if (amountCrafted > 0) {
                    event.whoClicked.inventory.addItem(item)
                    val matrixItems = event.inventory.matrix
                    val newMatrixItems = arrayOfNulls<ItemStack>(9)
                    for ((i, matrixItem) in matrixItems.withIndex()) {
                        if (matrixItem == null) {
                            continue
                        }
                        matrixItem.amount -= amountCrafted
                        if (matrixItem.amount <= 0) {
                            newMatrixItems[i] = null
                            event.inventory.result = null
                        } else {
                            newMatrixItems[i] = matrixItem
                        }
                    }
                }
            } else {
                if (amountCrafted > 0) {
                    event.currentItem = item
                    event.isCancelled = false
                } else {
                    event.currentItem = null
                    val matrixItems = event.inventory.matrix
                    val newMatrixItems = arrayOfNulls<ItemStack>(9)
                    for ((i, matrixItem) in matrixItems.withIndex()) {
                        if (matrixItem == null) {
                            continue
                        }
                        matrixItem.amount -= amountCrafted
                        if (matrixItem.amount <= 0) {
                            newMatrixItems[i] = null
                        } else {
                            newMatrixItems[i] = matrixItem
                        }
                    }
                    event.inventory.matrix = newMatrixItems
                }
            }
            professions.forEach { profession ->
                val receivedExperience = plugin.config.getInt("professions.${profession.name}.experience.items.crafting.$itemType", 0) * amountCrafted
                if (receivedExperience > 0) {
                    professionProvider.setProfessionExperience(character, profession, professionProvider.getProfessionExperience(character, profession) + receivedExperience)
                    val level = professionProvider.getProfessionLevel(character, profession)
                    val experience = professionProvider.getProfessionExperience(character, profession)
                    event.whoClicked.sendMessage(plugin.messages["craft-experience", mapOf(
                            "profession" to profession.name,
                            "level" to level.toString(),
                            "received-experience" to receivedExperience.toString(),
                            "experience" to (experience - profession.getExperienceNeededForLevel(level)).toString(),
                            "next-level-experience" to (profession.getExperienceNeededForLevel(level + 1) - profession.getExperienceNeededForLevel(level)).toString(),
                            "total-experience" to experience.toString(),
                            "total-next-level-experience" to profession.getExperienceNeededForLevel(level + 1).toString(),
                            "material" to itemType.toString().toLowerCase().replace('_', ' ')
                    )])
                }
            }
        }
    }

    private fun getAmountCrafted(event: CraftItemEvent): Int {
        val cursor = event.cursor
        var amount = event.recipe.result.amount
        if (event.isShiftClick) {
            var max = event.inventory.maxStackSize
            val matrix = event.inventory.matrix
            matrix.asSequence()
                    .filter { it != null && it.type != Material.AIR }
                    .map { it.amount }
                    .filter { it in 1 until max }
                    .forEach { max = it }
            amount *= max
        } else {
            if (cursor != null) {
                if (cursor.type != Material.AIR) {
                    return 0
                }
            }
        }
        var spacesFree = 0
        repeat((event.whoClicked as Player).inventory.storageContents.filter { it == null }.size) {
            spacesFree += event.recipe.result.type.maxStackSize
        }
        (event.whoClicked as Player).inventory.storageContents
                .filter { it != null && it.isSimilar(event.recipe.result) }
                .forEach { spacesFree += it.type.maxStackSize - it.amount }
        if (spacesFree < amount) {
            amount = spacesFree
        }
        return amount
    }

}