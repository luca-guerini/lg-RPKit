/*
 * This file is generated by jOOQ.
 */
package com.rpkit.permissions.bukkit.database.jooq.tables;


import com.rpkit.permissions.bukkit.database.jooq.RpkitPermissions;
import com.rpkit.permissions.bukkit.database.jooq.tables.records.RpkitCharacterGroupRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterGroup extends TableImpl<RpkitCharacterGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_permissions.rpkit_character_group</code>
     */
    public static final RpkitCharacterGroup RPKIT_CHARACTER_GROUP = new RpkitCharacterGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitCharacterGroupRecord> getRecordType() {
        return RpkitCharacterGroupRecord.class;
    }

    /**
     * The column <code>rpkit_permissions.rpkit_character_group.character_id</code>.
     */
    public final TableField<RpkitCharacterGroupRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_permissions.rpkit_character_group.group_name</code>.
     */
    public final TableField<RpkitCharacterGroupRecord, String> GROUP_NAME = createField(DSL.name("group_name"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>rpkit_permissions.rpkit_character_group.priority</code>.
     */
    public final TableField<RpkitCharacterGroupRecord, Integer> PRIORITY = createField(DSL.name("priority"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitCharacterGroup(Name alias, Table<RpkitCharacterGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitCharacterGroup(Name alias, Table<RpkitCharacterGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_permissions.rpkit_character_group</code> table reference
     */
    public RpkitCharacterGroup(String alias) {
        this(DSL.name(alias), RPKIT_CHARACTER_GROUP);
    }

    /**
     * Create an aliased <code>rpkit_permissions.rpkit_character_group</code> table reference
     */
    public RpkitCharacterGroup(Name alias) {
        this(alias, RPKIT_CHARACTER_GROUP);
    }

    /**
     * Create a <code>rpkit_permissions.rpkit_character_group</code> table reference
     */
    public RpkitCharacterGroup() {
        this(DSL.name("rpkit_character_group"), null);
    }

    public <O extends Record> RpkitCharacterGroup(Table<O> child, ForeignKey<O, RpkitCharacterGroupRecord> key) {
        super(child, key, RPKIT_CHARACTER_GROUP);
    }

    @Override
    public Schema getSchema() {
        return RpkitPermissions.RPKIT_PERMISSIONS;
    }

    @Override
    public RpkitCharacterGroup as(String alias) {
        return new RpkitCharacterGroup(DSL.name(alias), this);
    }

    @Override
    public RpkitCharacterGroup as(Name alias) {
        return new RpkitCharacterGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterGroup rename(String name) {
        return new RpkitCharacterGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterGroup rename(Name name) {
        return new RpkitCharacterGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}