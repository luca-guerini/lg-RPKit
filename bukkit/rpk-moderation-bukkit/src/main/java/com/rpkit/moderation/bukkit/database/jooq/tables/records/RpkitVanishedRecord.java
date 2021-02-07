/*
 * This file is generated by jOOQ.
 */
package com.rpkit.moderation.bukkit.database.jooq.tables.records;


import com.rpkit.moderation.bukkit.database.jooq.tables.RpkitVanished;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitVanishedRecord extends UpdatableRecordImpl<RpkitVanishedRecord> implements Record1<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rpkit_moderation.rpkit_vanished.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_moderation.rpkit_vanished.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<Integer> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitVanished.RPKIT_VANISHED.MINECRAFT_PROFILE_ID;
    }

    @Override
    public Integer component1() {
        return getMinecraftProfileId();
    }

    @Override
    public Integer value1() {
        return getMinecraftProfileId();
    }

    @Override
    public RpkitVanishedRecord value1(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    @Override
    public RpkitVanishedRecord values(Integer value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitVanishedRecord
     */
    public RpkitVanishedRecord() {
        super(RpkitVanished.RPKIT_VANISHED);
    }

    /**
     * Create a detached, initialised RpkitVanishedRecord
     */
    public RpkitVanishedRecord(Integer minecraftProfileId) {
        super(RpkitVanished.RPKIT_VANISHED);

        setMinecraftProfileId(minecraftProfileId);
    }
}