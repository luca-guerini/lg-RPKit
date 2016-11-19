/*
 * Copyright 2016 Ross Binden
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

package com.seventh_root.elysium.characters.bukkit.character

import com.seventh_root.elysium.characters.bukkit.ElysiumCharactersBukkit
import com.seventh_root.elysium.characters.bukkit.character.field.ElysiumCharacterCardFieldProvider
import com.seventh_root.elysium.characters.bukkit.character.field.HideableCharacterCardField
import com.seventh_root.elysium.characters.bukkit.gender.ElysiumGender
import com.seventh_root.elysium.characters.bukkit.gender.ElysiumGenderProvider
import com.seventh_root.elysium.characters.bukkit.race.ElysiumRace
import com.seventh_root.elysium.characters.bukkit.race.ElysiumRaceProvider
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayer
import mkremins.fanciful.FancyMessage
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.inventory.ItemStack

/**
 * Character implementation.
 */
class ElysiumCharacterImpl constructor(
        val plugin: ElysiumCharactersBukkit,
        override var id: Int = 0,
        override var player: ElysiumPlayer?,
        name: String = plugin.config.getString("characters.defaults.name"),
        override var gender: ElysiumGender? = if (plugin.config.getString("characters.defaults.gender") != null) plugin.core.serviceManager.getServiceProvider(ElysiumGenderProvider::class).getGender(plugin.config.getString("characters.defaults.gender")) else null,
        override var age: Int = plugin.config.getInt("characters.defaults.age"),
        override var race: ElysiumRace? = if (plugin.config.getString("characters.defaults.race") != null) plugin.core.serviceManager.getServiceProvider(ElysiumRaceProvider::class).getRace(plugin.config.getString("characters.defaults.race")) else null,
        description: String = plugin.config.getString("characters.defaults.description"),
        dead: Boolean = plugin.config.getBoolean("characters.defaults.dead"),
        override var location: Location = Bukkit.getWorlds()[0].spawnLocation,
        override var inventoryContents: Array<ItemStack> = (plugin.config.getList("characters.defaults.inventory-contents") as MutableList<ItemStack>).toTypedArray(),
        override var helmet: ItemStack? = plugin.config.getItemStack("characters.defaults.helmet"),
        override var chestplate: ItemStack? = plugin.config.getItemStack("characters.defaults.chestplate"),
        override var leggings: ItemStack? = plugin.config.getItemStack("characters.defaults.leggings"),
        override var boots: ItemStack? = plugin.config.getItemStack("characters.defaults.boots"),
        override var health: Double = plugin.config.getInt("characters.defaults.health").toDouble(),
        override var maxHealth: Double = plugin.config.getInt("characters.defaults.max-health").toDouble(),
        override var mana: Int = plugin.config.getInt("characters.defaults.mana"),
        override var maxMana: Int = plugin.config.getInt("characters.defaults.max-mana"),
        override var foodLevel: Int = plugin.config.getInt("characters.defaults.food-level"),
        override var thirstLevel: Int = plugin.config.getInt("characters.defaults.thirst-level"),
        override var isPlayerHidden: Boolean = plugin.config.getBoolean("characters.defaults.player-hidden"),
        override var isNameHidden: Boolean = plugin.config.getBoolean("characters.defaults.name-hidden"),
        override var isGenderHidden: Boolean = plugin.config.getBoolean("characters.defaults.gender-hidden"),
        override var isAgeHidden: Boolean = plugin.config.getBoolean("characters.defaults.age-hidden"),
        override var isRaceHidden: Boolean = plugin.config.getBoolean("characters.defaults.race-hidden"),
        override var isDescriptionHidden: Boolean = plugin.config.getBoolean("characters.defaults.description-hidden")
): ElysiumCharacter {

    override var name = name
        set(name) {
            field = name
            if (plugin.config.getBoolean("characters.set-player-display-name"))
            (player as? ElysiumPlayer)?.bukkitPlayer?.player?.displayName = name
        }
    override var description = description
        set(description) {
            field = description
            if (field.length > 1024) {
                field = field.substring(0, 1021) + "..."
            }
        }
    override var isDead = dead

    override fun showCharacterCard(player: ElysiumPlayer) {
        val offlineBukkitPlayer = player.bukkitPlayer
        if (offlineBukkitPlayer != null) {
            if (offlineBukkitPlayer.isOnline) {
                val bukkitPlayer = offlineBukkitPlayer.player
                val characterCardFieldProvider = plugin.core.serviceManager.getServiceProvider(ElysiumCharacterCardFieldProvider::class)
                for (line in plugin.config.getStringList("messages.character-card")) {
                    val message = FancyMessage("")
                    var chatColor: ChatColor? = null
                    var chatFormat: ChatColor? = null
                    var i = 0
                    while (i < line.length) {
                        if (line[i] === '&') {
                            val colourOrFormat = ChatColor.getByChar(line[i + 1])
                            if (colourOrFormat.isColor) {
                                chatColor = colourOrFormat
                                chatFormat = null
                            }
                            if (colourOrFormat.isFormat) chatFormat = colourOrFormat
                            i += 1
                        } else {
                            var fieldFound = false
                            characterCardFieldProvider.characterCardFields
                                    .filter { field -> line.length >= i + "\$${field.name}".length }
                                    .filter { field -> line.substring(i, i + "\$${field.name}".length) == "\$${field.name}" }
                                    .forEach { field ->
                                        message.then(field.get(this))
                                        if (chatColor != null) {
                                            message.color(chatColor)
                                        }
                                        if (chatFormat != null) {
                                            message.style(chatFormat)
                                        }
                                        i += "\$${field.name}".length - 1
                                        fieldFound = true
                                    }
                            if (!fieldFound) {
                                var editFound = false
                                characterCardFieldProvider.characterCardFields
                                        .filter { field -> line.length >= i + "\$edit(${field.name})".length }
                                        .filter { field -> line.substring(i, i + "\$edit(${field.name})".length) == "\$edit(${field.name})" }
                                        .forEach { field ->
                                            if (player == this.player) {
                                                message.then("Edit")
                                                            .command("/character set ${field.name}")
                                                            .tooltip("Click to change your character's ${field.name}")
                                                if (chatColor != null) {
                                                    message.color(chatColor)
                                                }
                                                if (chatFormat != null) {
                                                    message.style(chatFormat)
                                                }
                                            }
                                            i += "\$edit(${field.name})".length - 1
                                            editFound = true
                                        }
                                if (!editFound) {
                                    var hideFound = false
                                    characterCardFieldProvider.characterCardFields
                                            .filter { field -> line.length >= i + "\$hide(${field.name})".length }
                                            .filter { field -> line.substring(i, i + "\$hide(${field.name})".length) == "\$hide(${field.name})" }
                                            .filter { it is HideableCharacterCardField }
                                            .map { field -> field as HideableCharacterCardField }
                                            .forEach { field ->
                                                if (player == this.player) {
                                                    if (field.isHidden(this)) {
                                                        message.then("Unhide")
                                                                .command("/character unhide ${field.name}")
                                                                .tooltip("Click to unhide your character's ${field.name}")
                                                    } else {
                                                        message.then("Hide")
                                                                .command("/character hide ${field.name}")
                                                                .tooltip("Click to hide your character's ${field.name}")
                                                    }
                                                    if (chatColor != null) {
                                                        message.color(chatColor)
                                                    }
                                                    if (chatFormat != null) {
                                                        message.style(chatFormat)
                                                    }
                                                }
                                                i += "\$hide(${field.name})".length - 1
                                                hideFound = true
                                            }
                                    if (!hideFound) {
                                        message.then(Character.toString(line[i]))
                                        if (chatColor != null) {
                                            message.color(chatColor)
                                        }
                                        if (chatFormat != null) {
                                            message.style(chatFormat)
                                        }
                                    }
                                }
                            }
                        }
                        i++
                    }
                    message.send(bukkitPlayer)
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as ElysiumCharacterImpl

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }


}
