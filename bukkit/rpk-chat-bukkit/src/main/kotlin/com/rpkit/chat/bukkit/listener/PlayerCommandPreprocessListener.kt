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

package com.rpkit.chat.bukkit.listener

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.chatchannel.RPKChatChannelProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

/**
 * Player command preprocess listener.
 * Picks up commands before they are sent to normal chat processing, allowing them to be interpreted as chat channel
 * commands.
 * Hacky and circumvents the command system, but users are stuck in their ways.
 */
class PlayerCommandPreprocessListener(private val plugin: RPKChatBukkit): Listener {

    @EventHandler
    fun onPlayerCommandPreProcess(event: PlayerCommandPreprocessEvent) {
        val chatChannelName = event.message.split(Regex("\\s+"))[0].drop(1)
        val chatChannelProvider = plugin.core.serviceManager.getServiceProvider(RPKChatChannelProvider::class)
        val chatChannel = chatChannelProvider.getChatChannel(chatChannelName)
        if (chatChannel != null) {
            if (event.player.hasPermission("rpkit.chat.command.chatchannel.${chatChannel.name}")) {
                event.isCancelled = true
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val player = playerProvider.getPlayer(event.player)
                if (event.message.startsWith("/$chatChannelName ")) {
                    chatChannel.sendMessage(player, event.message.split(Regex("\\s+")).drop(1).joinToString(" "))
                } else if (event.message.startsWith("/$chatChannelName")) {
                    chatChannel.addSpeaker(player)
                    event.player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.chatchannel-valid"))
                            .replace("\$channel", chatChannel.name))
                }
            } else {
                event.isCancelled = true
                event.player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.no-permission-chatchannel"))
                        .replace("\$channel", chatChannel.name))
            }
        }
    }

}