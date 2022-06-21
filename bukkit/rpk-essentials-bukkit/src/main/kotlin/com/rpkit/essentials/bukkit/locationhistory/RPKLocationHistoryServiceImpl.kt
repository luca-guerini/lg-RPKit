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

package com.rpkit.essentials.bukkit.locationhistory

import com.rpkit.core.bukkit.location.toBukkitLocation
import com.rpkit.core.bukkit.location.toRPKLocation
import com.rpkit.essentials.bukkit.RPKEssentialsBukkit
import com.rpkit.essentials.bukkit.database.table.RPKPreviousLocationTable
import com.rpkit.locationhistory.bukkit.locationhistory.RPKLocationHistoryService
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfile
import org.bukkit.Location
import java.util.concurrent.CompletableFuture
import java.util.logging.Level


class RPKLocationHistoryServiceImpl(override val plugin: RPKEssentialsBukkit) : RPKLocationHistoryService {

    override fun getPreviousLocation(minecraftProfile: RPKMinecraftProfile): CompletableFuture<Location?> {
        return plugin.database.getTable(RPKPreviousLocationTable::class.java)[minecraftProfile].thenApply {
            it?.location?.toBukkitLocation()
        }
    }

    override fun setPreviousLocation(minecraftProfile: RPKMinecraftProfile, location: Location): CompletableFuture<Void> {
        return CompletableFuture.runAsync {
            val previousLocationTable = plugin.database.getTable(RPKPreviousLocationTable::class.java)
            var previousLocation = previousLocationTable[minecraftProfile].join()
            if (previousLocation != null) {
                previousLocation.location = location.toRPKLocation()
                previousLocationTable.update(previousLocation).join()
            } else {
                previousLocation = RPKPreviousLocation(minecraftProfile = minecraftProfile, location = location.toRPKLocation())
                previousLocationTable.insert(previousLocation).join()
            }
        }.exceptionally { exception ->
            plugin.logger.log(Level.SEVERE, "Failed to set previous location", exception)
            throw exception
        }
    }

}