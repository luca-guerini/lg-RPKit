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

package com.seventh_root.elysium.players.bukkit

import com.seventh_root.elysium.core.bukkit.plugin.ElysiumBukkitPlugin
import com.seventh_root.elysium.core.database.Database
import com.seventh_root.elysium.core.service.ServiceProvider
import com.seventh_root.elysium.core.web.NavigationLink
import com.seventh_root.elysium.players.bukkit.command.account.AccountCommand
import com.seventh_root.elysium.players.bukkit.database.table.ElysiumPlayerTable
import com.seventh_root.elysium.players.bukkit.listener.PlayerJoinListener
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayerProvider
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayerProviderImpl
import com.seventh_root.elysium.players.bukkit.servlet.PlayerServlet
import com.seventh_root.elysium.players.bukkit.servlet.PlayersServlet
import com.seventh_root.elysium.players.bukkit.servlet.api.v0_4.PlayerAPIServlet
import java.sql.SQLException

/**
 * Elysium players plugin default implementation.
 */
class ElysiumPlayersBukkit: ElysiumBukkitPlugin() {

    private lateinit var playerProvider: ElysiumPlayerProvider

    override fun onEnable() {
        playerProvider = ElysiumPlayerProviderImpl(this)
        serviceProviders = arrayOf<ServiceProvider>(playerProvider)
        servlets = arrayOf(PlayersServlet(this), PlayerServlet(this), PlayerAPIServlet(this))
    }

    override fun onPostEnable() {
        core.web.navigationBar.add(NavigationLink("Players", "/players/"))
    }

    override fun registerCommands() {
        getCommand("account").executor = AccountCommand(this)
    }

    override fun registerListeners() {
        registerListeners(PlayerJoinListener(this))
    }

    @Throws(SQLException::class)
    override fun createTables(database: Database) {
        database.addTable(ElysiumPlayerTable(this, database))
    }

}
