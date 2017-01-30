package com.rpkit.essentials.bukkit.command

import com.rpkit.essentials.bukkit.RPKEssentialsBukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.BookMeta

class UnsignCommand(private val plugin: RPKEssentialsBukkit) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender.hasPermission("rpkit.essentials.command.unsign")) {
            if (sender is Player) {
                if (sender.inventory.itemInMainHand != null) {
                    if (sender.inventory.itemInMainHand.type == Material.WRITTEN_BOOK) {
                        val meta = sender.inventory.itemInMainHand.itemMeta as BookMeta
                        sender.inventory.itemInMainHand.type = Material.BOOK_AND_QUILL
                        sender.inventory.itemInMainHand.itemMeta = meta
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.unsign-valid")))
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.unsign-invalid-book")))
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.unsign-invalid-book")))
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.not-from-console")))
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.no-permission-unsign")))
        }
        return true
    }

}