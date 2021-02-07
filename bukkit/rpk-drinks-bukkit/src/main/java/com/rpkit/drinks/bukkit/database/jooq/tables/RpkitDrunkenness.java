/*
 * This file is generated by jOOQ.
 */
package com.rpkit.drinks.bukkit.database.jooq.tables;


import com.rpkit.drinks.bukkit.database.jooq.Keys;
import com.rpkit.drinks.bukkit.database.jooq.RpkitDrinks;
import com.rpkit.drinks.bukkit.database.jooq.tables.records.RpkitDrunkennessRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class RpkitDrunkenness extends TableImpl<RpkitDrunkennessRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_drinks.rpkit_drunkenness</code>
     */
    public static final RpkitDrunkenness RPKIT_DRUNKENNESS = new RpkitDrunkenness();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitDrunkennessRecord> getRecordType() {
        return RpkitDrunkennessRecord.class;
    }

    /**
     * The column <code>rpkit_drinks.rpkit_drunkenness.character_id</code>.
     */
    public final TableField<RpkitDrunkennessRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_drinks.rpkit_drunkenness.drunkenness</code>.
     */
    public final TableField<RpkitDrunkennessRecord, Integer> DRUNKENNESS = createField(DSL.name("drunkenness"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitDrunkenness(Name alias, Table<RpkitDrunkennessRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitDrunkenness(Name alias, Table<RpkitDrunkennessRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_drinks.rpkit_drunkenness</code> table reference
     */
    public RpkitDrunkenness(String alias) {
        this(DSL.name(alias), RPKIT_DRUNKENNESS);
    }

    /**
     * Create an aliased <code>rpkit_drinks.rpkit_drunkenness</code> table reference
     */
    public RpkitDrunkenness(Name alias) {
        this(alias, RPKIT_DRUNKENNESS);
    }

    /**
     * Create a <code>rpkit_drinks.rpkit_drunkenness</code> table reference
     */
    public RpkitDrunkenness() {
        this(DSL.name("rpkit_drunkenness"), null);
    }

    public <O extends Record> RpkitDrunkenness(Table<O> child, ForeignKey<O, RpkitDrunkennessRecord> key) {
        super(child, key, RPKIT_DRUNKENNESS);
    }

    @Override
    public Schema getSchema() {
        return RpkitDrinks.RPKIT_DRINKS;
    }

    @Override
    public UniqueKey<RpkitDrunkennessRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_DRUNKENNESS_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitDrunkennessRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitDrunkennessRecord>>asList(Keys.KEY_RPKIT_DRUNKENNESS_PRIMARY);
    }

    @Override
    public RpkitDrunkenness as(String alias) {
        return new RpkitDrunkenness(DSL.name(alias), this);
    }

    @Override
    public RpkitDrunkenness as(Name alias) {
        return new RpkitDrunkenness(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitDrunkenness rename(String name) {
        return new RpkitDrunkenness(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitDrunkenness rename(Name name) {
        return new RpkitDrunkenness(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}