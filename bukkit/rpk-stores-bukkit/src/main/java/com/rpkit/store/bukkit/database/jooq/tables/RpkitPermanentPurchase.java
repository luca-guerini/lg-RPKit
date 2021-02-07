/*
 * This file is generated by jOOQ.
 */
package com.rpkit.store.bukkit.database.jooq.tables;


import com.rpkit.store.bukkit.database.jooq.Keys;
import com.rpkit.store.bukkit.database.jooq.RpkitStores;
import com.rpkit.store.bukkit.database.jooq.tables.records.RpkitPermanentPurchaseRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class RpkitPermanentPurchase extends TableImpl<RpkitPermanentPurchaseRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_stores.rpkit_permanent_purchase</code>
     */
    public static final RpkitPermanentPurchase RPKIT_PERMANENT_PURCHASE = new RpkitPermanentPurchase();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitPermanentPurchaseRecord> getRecordType() {
        return RpkitPermanentPurchaseRecord.class;
    }

    /**
     * The column <code>rpkit_stores.rpkit_permanent_purchase.id</code>.
     */
    public final TableField<RpkitPermanentPurchaseRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_permanent_purchase.purchase_id</code>.
     */
    public final TableField<RpkitPermanentPurchaseRecord, Integer> PURCHASE_ID = createField(DSL.name("purchase_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitPermanentPurchase(Name alias, Table<RpkitPermanentPurchaseRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitPermanentPurchase(Name alias, Table<RpkitPermanentPurchaseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_permanent_purchase</code> table reference
     */
    public RpkitPermanentPurchase(String alias) {
        this(DSL.name(alias), RPKIT_PERMANENT_PURCHASE);
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_permanent_purchase</code> table reference
     */
    public RpkitPermanentPurchase(Name alias) {
        this(alias, RPKIT_PERMANENT_PURCHASE);
    }

    /**
     * Create a <code>rpkit_stores.rpkit_permanent_purchase</code> table reference
     */
    public RpkitPermanentPurchase() {
        this(DSL.name("rpkit_permanent_purchase"), null);
    }

    public <O extends Record> RpkitPermanentPurchase(Table<O> child, ForeignKey<O, RpkitPermanentPurchaseRecord> key) {
        super(child, key, RPKIT_PERMANENT_PURCHASE);
    }

    @Override
    public Schema getSchema() {
        return RpkitStores.RPKIT_STORES;
    }

    @Override
    public Identity<RpkitPermanentPurchaseRecord, Integer> getIdentity() {
        return (Identity<RpkitPermanentPurchaseRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitPermanentPurchaseRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_PERMANENT_PURCHASE_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitPermanentPurchaseRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitPermanentPurchaseRecord>>asList(Keys.KEY_RPKIT_PERMANENT_PURCHASE_PRIMARY);
    }

    @Override
    public RpkitPermanentPurchase as(String alias) {
        return new RpkitPermanentPurchase(DSL.name(alias), this);
    }

    @Override
    public RpkitPermanentPurchase as(Name alias) {
        return new RpkitPermanentPurchase(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPermanentPurchase rename(String name) {
        return new RpkitPermanentPurchase(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPermanentPurchase rename(Name name) {
        return new RpkitPermanentPurchase(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}