/*
 * This file is generated by jOOQ.
 */
package com.rpkit.players.bukkit.database.jooq.tables.records;


import com.rpkit.players.bukkit.database.jooq.tables.RpkitDiscordProfile;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitDiscordProfileRecord extends UpdatableRecordImpl<RpkitDiscordProfileRecord> implements Record3<Integer, Integer, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rpkit_players.rpkit_discord_profile.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_players.rpkit_discord_profile.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit_players.rpkit_discord_profile.profile_id</code>.
     */
    public void setProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_players.rpkit_discord_profile.profile_id</code>.
     */
    public Integer getProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit_players.rpkit_discord_profile.discord_id</code>.
     */
    public void setDiscordId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit_players.rpkit_discord_profile.discord_id</code>.
     */
    public Long getDiscordId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Integer, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitDiscordProfile.RPKIT_DISCORD_PROFILE.ID;
    }

    @Override
    public Field<Integer> field2() {
        return RpkitDiscordProfile.RPKIT_DISCORD_PROFILE.PROFILE_ID;
    }

    @Override
    public Field<Long> field3() {
        return RpkitDiscordProfile.RPKIT_DISCORD_PROFILE.DISCORD_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getProfileId();
    }

    @Override
    public Long component3() {
        return getDiscordId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getProfileId();
    }

    @Override
    public Long value3() {
        return getDiscordId();
    }

    @Override
    public RpkitDiscordProfileRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RpkitDiscordProfileRecord value2(Integer value) {
        setProfileId(value);
        return this;
    }

    @Override
    public RpkitDiscordProfileRecord value3(Long value) {
        setDiscordId(value);
        return this;
    }

    @Override
    public RpkitDiscordProfileRecord values(Integer value1, Integer value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitDiscordProfileRecord
     */
    public RpkitDiscordProfileRecord() {
        super(RpkitDiscordProfile.RPKIT_DISCORD_PROFILE);
    }

    /**
     * Create a detached, initialised RpkitDiscordProfileRecord
     */
    public RpkitDiscordProfileRecord(Integer id, Integer profileId, Long discordId) {
        super(RpkitDiscordProfile.RPKIT_DISCORD_PROFILE);

        setId(id);
        setProfileId(profileId);
        setDiscordId(discordId);
    }
}