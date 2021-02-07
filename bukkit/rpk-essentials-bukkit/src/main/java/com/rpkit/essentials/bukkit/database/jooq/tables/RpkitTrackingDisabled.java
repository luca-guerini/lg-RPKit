/*
 * This file is generated by jOOQ.
 */
package com.rpkit.essentials.bukkit.database.jooq.tables;


import com.rpkit.essentials.bukkit.database.jooq.Keys;
import com.rpkit.essentials.bukkit.database.jooq.RpkitEssentials;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.RpkitTrackingDisabledRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitTrackingDisabled extends TableImpl<RpkitTrackingDisabledRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_essentials.rpkit_tracking_disabled</code>
     */
    public static final RpkitTrackingDisabled RPKIT_TRACKING_DISABLED = new RpkitTrackingDisabled();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitTrackingDisabledRecord> getRecordType() {
        return RpkitTrackingDisabledRecord.class;
    }

    /**
     * The column <code>rpkit_essentials.rpkit_tracking_disabled.character_id</code>.
     */
    public final TableField<RpkitTrackingDisabledRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitTrackingDisabled(Name alias, Table<RpkitTrackingDisabledRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitTrackingDisabled(Name alias, Table<RpkitTrackingDisabledRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_essentials.rpkit_tracking_disabled</code> table reference
     */
    public RpkitTrackingDisabled(String alias) {
        this(DSL.name(alias), RPKIT_TRACKING_DISABLED);
    }

    /**
     * Create an aliased <code>rpkit_essentials.rpkit_tracking_disabled</code> table reference
     */
    public RpkitTrackingDisabled(Name alias) {
        this(alias, RPKIT_TRACKING_DISABLED);
    }

    /**
     * Create a <code>rpkit_essentials.rpkit_tracking_disabled</code> table reference
     */
    public RpkitTrackingDisabled() {
        this(DSL.name("rpkit_tracking_disabled"), null);
    }

    public <O extends Record> RpkitTrackingDisabled(Table<O> child, ForeignKey<O, RpkitTrackingDisabledRecord> key) {
        super(child, key, RPKIT_TRACKING_DISABLED);
    }

    @Override
    public Schema getSchema() {
        return RpkitEssentials.RPKIT_ESSENTIALS;
    }

    @Override
    public UniqueKey<RpkitTrackingDisabledRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_TRACKING_DISABLED_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitTrackingDisabledRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitTrackingDisabledRecord>>asList(Keys.KEY_RPKIT_TRACKING_DISABLED_PRIMARY);
    }

    @Override
    public RpkitTrackingDisabled as(String alias) {
        return new RpkitTrackingDisabled(DSL.name(alias), this);
    }

    @Override
    public RpkitTrackingDisabled as(Name alias) {
        return new RpkitTrackingDisabled(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitTrackingDisabled rename(String name) {
        return new RpkitTrackingDisabled(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitTrackingDisabled rename(Name name) {
        return new RpkitTrackingDisabled(name, null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }
}