/*
 * This file is generated by jOOQ.
 */
package com.rpkit.shops.bukkit.database.jooq.tables;


import com.rpkit.shops.bukkit.database.jooq.Keys;
import com.rpkit.shops.bukkit.database.jooq.RpkitShops;
import com.rpkit.shops.bukkit.database.jooq.tables.records.RpkitShopCountRecord;

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
public class RpkitShopCount extends TableImpl<RpkitShopCountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_shops.rpkit_shop_count</code>
     */
    public static final RpkitShopCount RPKIT_SHOP_COUNT = new RpkitShopCount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitShopCountRecord> getRecordType() {
        return RpkitShopCountRecord.class;
    }

    /**
     * The column <code>rpkit_shops.rpkit_shop_count.character_id</code>.
     */
    public final TableField<RpkitShopCountRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_shops.rpkit_shop_count.count</code>.
     */
    public final TableField<RpkitShopCountRecord, Integer> COUNT = createField(DSL.name("count"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitShopCount(Name alias, Table<RpkitShopCountRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitShopCount(Name alias, Table<RpkitShopCountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_shops.rpkit_shop_count</code> table
     * reference
     */
    public RpkitShopCount(String alias) {
        this(DSL.name(alias), RPKIT_SHOP_COUNT);
    }

    /**
     * Create an aliased <code>rpkit_shops.rpkit_shop_count</code> table
     * reference
     */
    public RpkitShopCount(Name alias) {
        this(alias, RPKIT_SHOP_COUNT);
    }

    /**
     * Create a <code>rpkit_shops.rpkit_shop_count</code> table reference
     */
    public RpkitShopCount() {
        this(DSL.name("rpkit_shop_count"), null);
    }

    public <O extends Record> RpkitShopCount(Table<O> child, ForeignKey<O, RpkitShopCountRecord> key) {
        super(child, key, RPKIT_SHOP_COUNT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RpkitShops.RPKIT_SHOPS;
    }

    @Override
    public UniqueKey<RpkitShopCountRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_SHOP_COUNT_PRIMARY;
    }

    @Override
    public RpkitShopCount as(String alias) {
        return new RpkitShopCount(DSL.name(alias), this);
    }

    @Override
    public RpkitShopCount as(Name alias) {
        return new RpkitShopCount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitShopCount rename(String name) {
        return new RpkitShopCount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitShopCount rename(Name name) {
        return new RpkitShopCount(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
