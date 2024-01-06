/*
 * Copyright 2022 Ren Binden
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

package com.rpkit.drinks.bukkit.listener

import com.rpkit.characters.bukkit.event.character.RPKBukkitCharacterDeleteEvent
import com.rpkit.drinks.bukkit.RPKDrinksBukkit
import com.rpkit.drinks.bukkit.database.table.RPKDrunkennessTable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class RPKCharacterDeleteListener(private val plugin: RPKDrinksBukkit) : Listener {

    @EventHandler
    fun onCharacterDelete(event: RPKBukkitCharacterDeleteEvent) {
        val characterId = event.character.id
        if (characterId != null) {
            plugin.database.getTable(RPKDrunkennessTable::class.java).delete(characterId)
        }
    }

}