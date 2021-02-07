/*
 * This file is generated by jOOQ.
 */
package com.rpkit.blocklog.bukkit.database.jooq.tables;


import com.rpkit.blocklog.bukkit.database.jooq.Keys;
import com.rpkit.blocklog.bukkit.database.jooq.RpkitBlockLogging;
import com.rpkit.blocklog.bukkit.database.jooq.tables.records.RpkitBlockInventoryChangeRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitBlockInventoryChange extends TableImpl<RpkitBlockInventoryChangeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_block_logging.rpkit_block_inventory_change</code>
     */
    public static final RpkitBlockInventoryChange RPKIT_BLOCK_INVENTORY_CHANGE = new RpkitBlockInventoryChange();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitBlockInventoryChangeRecord> getRecordType() {
        return RpkitBlockInventoryChangeRecord.class;
    }

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.block_history_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> BLOCK_HISTORY_ID = createField(DSL.name("block_history_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.time</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, LocalDateTime> TIME = createField(DSL.name("time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("current_timestamp()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.profile_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> PROFILE_ID = createField(DSL.name("profile_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.minecraft_profile_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> MINECRAFT_PROFILE_ID = createField(DSL.name("minecraft_profile_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.character_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.from</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, byte[]> FROM = createField(DSL.name("from"), SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.to</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, byte[]> TO = createField(DSL.name("to"), SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>rpkit_block_logging.rpkit_block_inventory_change.reason</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, String> REASON = createField(DSL.name("reason"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    private RpkitBlockInventoryChange(Name alias, Table<RpkitBlockInventoryChangeRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitBlockInventoryChange(Name alias, Table<RpkitBlockInventoryChangeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_block_logging.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange(String alias) {
        this(DSL.name(alias), RPKIT_BLOCK_INVENTORY_CHANGE);
    }

    /**
     * Create an aliased <code>rpkit_block_logging.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange(Name alias) {
        this(alias, RPKIT_BLOCK_INVENTORY_CHANGE);
    }

    /**
     * Create a <code>rpkit_block_logging.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange() {
        this(DSL.name("rpkit_block_inventory_change"), null);
    }

    public <O extends Record> RpkitBlockInventoryChange(Table<O> child, ForeignKey<O, RpkitBlockInventoryChangeRecord> key) {
        super(child, key, RPKIT_BLOCK_INVENTORY_CHANGE);
    }

    @Override
    public Schema getSchema() {
        return RpkitBlockLogging.RPKIT_BLOCK_LOGGING;
    }

    @Override
    public Identity<RpkitBlockInventoryChangeRecord, Integer> getIdentity() {
        return (Identity<RpkitBlockInventoryChangeRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitBlockInventoryChangeRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_BLOCK_INVENTORY_CHANGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitBlockInventoryChangeRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitBlockInventoryChangeRecord>>asList(Keys.KEY_RPKIT_BLOCK_INVENTORY_CHANGE_PRIMARY);
    }

    @Override
    public RpkitBlockInventoryChange as(String alias) {
        return new RpkitBlockInventoryChange(DSL.name(alias), this);
    }

    @Override
    public RpkitBlockInventoryChange as(Name alias) {
        return new RpkitBlockInventoryChange(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitBlockInventoryChange rename(String name) {
        return new RpkitBlockInventoryChange(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitBlockInventoryChange rename(Name name) {
        return new RpkitBlockInventoryChange(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, LocalDateTime, Integer, Integer, Integer, byte[], byte[], String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}