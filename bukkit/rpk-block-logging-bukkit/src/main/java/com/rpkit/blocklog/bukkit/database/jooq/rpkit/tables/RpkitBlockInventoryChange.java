/*
 * This file is generated by jOOQ.
*/
package com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables;


import com.rpkit.blocklog.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.records.RpkitBlockInventoryChangeRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitBlockInventoryChange extends TableImpl<RpkitBlockInventoryChangeRecord> {

    private static final long serialVersionUID = -478043203;

    /**
     * The reference instance of <code>rpkit.rpkit_block_inventory_change</code>
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
     * The column <code>rpkit.rpkit_block_inventory_change.id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.block_history_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> BLOCK_HISTORY_ID = createField("block_history_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.time</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Timestamp> TIME = createField("time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.profile_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> PROFILE_ID = createField("profile_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.minecraft_profile_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> MINECRAFT_PROFILE_ID = createField("minecraft_profile_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.character_id</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, Integer> CHARACTER_ID = createField("character_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.from</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, byte[]> FROM = createField("from", org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.to</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, byte[]> TO = createField("to", org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * The column <code>rpkit.rpkit_block_inventory_change.reason</code>.
     */
    public final TableField<RpkitBlockInventoryChangeRecord, String> REASON = createField("reason", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * Create a <code>rpkit.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange() {
        this(DSL.name("rpkit_block_inventory_change"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange(String alias) {
        this(DSL.name(alias), RPKIT_BLOCK_INVENTORY_CHANGE);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_block_inventory_change</code> table reference
     */
    public RpkitBlockInventoryChange(Name alias) {
        this(alias, RPKIT_BLOCK_INVENTORY_CHANGE);
    }

    private RpkitBlockInventoryChange(Name alias, Table<RpkitBlockInventoryChangeRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitBlockInventoryChange(Name alias, Table<RpkitBlockInventoryChangeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Rpkit.RPKIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.RPKIT_BLOCK_INVENTORY_CHANGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitBlockInventoryChangeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_BLOCK_INVENTORY_CHANGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitBlockInventoryChangeRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_BLOCK_INVENTORY_CHANGE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitBlockInventoryChangeRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitBlockInventoryChangeRecord>>asList(Keys.KEY_RPKIT_BLOCK_INVENTORY_CHANGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitBlockInventoryChange as(String alias) {
        return new RpkitBlockInventoryChange(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
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
}