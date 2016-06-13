package com.seventh_root.elysium.characters.bukkit.character

import com.seventh_root.elysium.api.character.ElysiumCharacter
import com.seventh_root.elysium.api.character.Gender
import com.seventh_root.elysium.api.character.Race
import com.seventh_root.elysium.api.player.ElysiumPlayer
import com.seventh_root.elysium.characters.bukkit.ElysiumCharactersBukkit
import com.seventh_root.elysium.characters.bukkit.gender.BukkitGenderProvider
import com.seventh_root.elysium.characters.bukkit.race.BukkitRaceProvider
import com.seventh_root.elysium.players.bukkit.BukkitPlayer
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.inventory.ItemStack
import java.util.*

class BukkitCharacter constructor(
        plugin: ElysiumCharactersBukkit,
        id: Int = 0,
        player: ElysiumPlayer?,
        name: String = plugin.config.getString("characters.defaults.name"),
        gender: Gender? = plugin.core.serviceManager.getServiceProvider(BukkitGenderProvider::class.java).getGender(plugin.config.getString("characters.defaults.gender")),
        age: Int = plugin.config.getInt("characters.defaults.age"),
        race: Race? = plugin.core.serviceManager.getServiceProvider(BukkitRaceProvider::class.java).getRace(plugin.config.getString("characters.defaults.race")),
        description: String = plugin.config.getString("characters.defaults.description"),
        dead: Boolean = plugin.config.getBoolean("characters.defaults.dead"),
        location: Location = Bukkit.getWorlds()[0].spawnLocation,
        inventoryContents: Array<ItemStack> = (plugin.config.getList("characters.defaults.inventory-contents") as ArrayList<ItemStack>).toTypedArray(),
        helmet: ItemStack? = plugin.config.getItemStack("characters.defaults.helmet"),
        chestplate: ItemStack? = plugin.config.getItemStack("characters.defaults.chestplate"),
        leggings: ItemStack? = plugin.config.getItemStack("characters.defaults.leggings"),
        boots: ItemStack? = plugin.config.getItemStack("characters.defaults.boots"),
        health: Double = plugin.config.getInt("characters.defaults.health").toDouble(),
        maxHealth: Double = plugin.config.getInt("characters.defaults.max-health").toDouble(),
        mana: Int = plugin.config.getInt("characters.defaults.mana"),
        maxMana: Int = plugin.config.getInt("characters.defaults.max-mana"),
        foodLevel: Int = plugin.config.getInt("characters.defaults.food-level"),
        thirstLevel: Int = plugin.config.getInt("characters.defaults.thirst-level")
) : ElysiumCharacter {

    val plugin = plugin
    override var id = id
    override var player = player
    override var name = name
        set(name) {
            field = name
            if (plugin.config.getBoolean("characters.set-player-display-name"))
            (player as? BukkitPlayer)?.bukkitPlayer?.player?.displayName = name
        }
    override var gender = gender
    override var age = age
    override var race = race
    override var description = description
        set(description) {
            field = description
            if (field.length > 1024) {
                field = field.substring(0, 1021) + "..."
            }
        }
    override var isDead = dead
    var location = location
    var inventoryContents = inventoryContents
    var helmet = helmet
    var chestplate = chestplate
    var leggings = leggings
    var boots = boots
    override var health = health
    override var maxHealth = maxHealth
    override var mana = mana
    override var maxMana = maxMana
    override var foodLevel = foodLevel
    override var thirstLevel = thirstLevel

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val character = other as BukkitCharacter?

        if (id != character!!.id) return false
        if (age != character.age) return false
        if (isDead != character.isDead) return false
        if (java.lang.Double.compare(character.health, health) != 0) return false
        if (java.lang.Double.compare(character.maxHealth, maxHealth) != 0) return false
        if (mana != character.mana) return false
        if (maxMana != character.maxMana) return false
        if (foodLevel != character.foodLevel) return false
        if (thirstLevel != character.thirstLevel) return false
        if (player != character.player) return false
        if (name != character.name) return false
        if (gender != character.gender) return false
        if (race != character.race) return false
        if (description != character.description) return false
        if (location != character.location) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(inventoryContents, character.inventoryContents)) return false
        if (if (helmet != null) helmet != character.helmet else character.helmet != null) return false
        if (if (chestplate != null) chestplate != character.chestplate else character.chestplate != null) return false
        if (if (leggings != null) leggings != character.leggings else character.leggings != null) return false
        return if (boots != null) boots == character.boots else character.boots == null

    }

    override fun hashCode(): Int {
        var result: Int
        var temp: Long
        result = id
        result = 31 * result + if (player != null) player!!.hashCode() else 0
        result = 31 * result + name.hashCode()
        result = 31 * result + if (gender != null) gender!!.hashCode() else 0
        result = 31 * result + age
        result = 31 * result + if (race != null) race!!.hashCode() else 0
        result = 31 * result + description.hashCode()
        result = 31 * result + if (isDead) 1 else 0
        result = 31 * result + location.hashCode()
        result = 31 * result + Arrays.hashCode(inventoryContents)
        result = 31 * result + if (helmet != null) helmet!!.hashCode() else 0
        result = 31 * result + if (chestplate != null) chestplate!!.hashCode() else 0
        result = 31 * result + if (leggings != null) leggings!!.hashCode() else 0
        result = 31 * result + if (boots != null) boots!!.hashCode() else 0
        temp = java.lang.Double.doubleToLongBits(health)
        result = 31 * result + (temp xor temp.ushr(32)).toInt()
        temp = java.lang.Double.doubleToLongBits(maxHealth)
        result = 31 * result + (temp xor temp.ushr(32)).toInt()
        result = 31 * result + mana
        result = 31 * result + maxMana
        result = 31 * result + foodLevel
        result = 31 * result + thirstLevel
        return result
    }

}
