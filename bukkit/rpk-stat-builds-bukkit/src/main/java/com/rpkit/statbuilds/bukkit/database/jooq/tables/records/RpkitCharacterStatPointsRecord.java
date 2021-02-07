/*
 * This file is generated by jOOQ.
 */
package com.rpkit.statbuilds.bukkit.database.jooq.tables.records;


import com.rpkit.statbuilds.bukkit.database.jooq.tables.RpkitCharacterStatPoints;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterStatPointsRecord extends TableRecordImpl<RpkitCharacterStatPointsRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rpkit_stat_builds.rpkit_character_stat_points.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_stat_builds.rpkit_character_stat_points.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit_stat_builds.rpkit_character_stat_points.stat_attribute</code>.
     */
    public void setStatAttribute(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_stat_builds.rpkit_character_stat_points.stat_attribute</code>.
     */
    public String getStatAttribute() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rpkit_stat_builds.rpkit_character_stat_points.points</code>.
     */
    public void setPoints(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit_stat_builds.rpkit_character_stat_points.points</code>.
     */
    public Integer getPoints() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS.CHARACTER_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS.STAT_ATTRIBUTE;
    }

    @Override
    public Field<Integer> field3() {
        return RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS.POINTS;
    }

    @Override
    public Integer component1() {
        return getCharacterId();
    }

    @Override
    public String component2() {
        return getStatAttribute();
    }

    @Override
    public Integer component3() {
        return getPoints();
    }

    @Override
    public Integer value1() {
        return getCharacterId();
    }

    @Override
    public String value2() {
        return getStatAttribute();
    }

    @Override
    public Integer value3() {
        return getPoints();
    }

    @Override
    public RpkitCharacterStatPointsRecord value1(Integer value) {
        setCharacterId(value);
        return this;
    }

    @Override
    public RpkitCharacterStatPointsRecord value2(String value) {
        setStatAttribute(value);
        return this;
    }

    @Override
    public RpkitCharacterStatPointsRecord value3(Integer value) {
        setPoints(value);
        return this;
    }

    @Override
    public RpkitCharacterStatPointsRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitCharacterStatPointsRecord
     */
    public RpkitCharacterStatPointsRecord() {
        super(RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS);
    }

    /**
     * Create a detached, initialised RpkitCharacterStatPointsRecord
     */
    public RpkitCharacterStatPointsRecord(Integer characterId, String statAttribute, Integer points) {
        super(RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS);

        setCharacterId(characterId);
        setStatAttribute(statAttribute);
        setPoints(points);
    }
}