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

package com.rpkit.locks.bukkit.listener

import com.rpkit.locks.bukkit.RPKLocksBukkit
import com.rpkit.locks.bukkit.database.table.RPKPlayerGettingKeyTable
import com.rpkit.locks.bukkit.database.table.RPKPlayerUnclaimingTable
import com.rpkit.players.bukkit.event.minecraftprofile.RPKBukkitMinecraftProfileDeleteEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class RPKMinecraftProfileDeleteListener(private val plugin: RPKLocksBukkit) : Listener {

    @EventHandler
    fun onMinecraftProfileDelete(event: RPKBukkitMinecraftProfileDeleteEvent) {
        val minecraftProfileId = event.minecraftProfile.id
        if (minecraftProfileId != null) {
            plugin.database.getTable(RPKPlayerGettingKeyTable::class.java).delete(minecraftProfileId)
            plugin.database.getTable(RPKPlayerUnclaimingTable::class.java).delete(minecraftProfileId)
        }
    }

}