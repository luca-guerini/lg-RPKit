/*
 * This file is generated by jOOQ.
 */
package com.rpkit.chat.bukkit.database.jooq.tables;


import com.rpkit.chat.bukkit.database.jooq.Keys;
import com.rpkit.chat.bukkit.database.jooq.RpkitChat;
import com.rpkit.chat.bukkit.database.jooq.tables.records.RpkitChatGroupRecord;

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
public class RpkitChatGroup extends TableImpl<RpkitChatGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_chat.rpkit_chat_group</code>
     */
    public static final RpkitChatGroup RPKIT_CHAT_GROUP = new RpkitChatGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitChatGroupRecord> getRecordType() {
        return RpkitChatGroupRecord.class;
    }

    /**
     * The column <code>rpkit_chat.rpkit_chat_group.id</code>.
     */
    public final TableField<RpkitChatGroupRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_chat.rpkit_chat_group.name</code>.
     */
    public final TableField<RpkitChatGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    private RpkitChatGroup(Name alias, Table<RpkitChatGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitChatGroup(Name alias, Table<RpkitChatGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_chat_group</code> table reference
     */
    public RpkitChatGroup(String alias) {
        this(DSL.name(alias), RPKIT_CHAT_GROUP);
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_chat_group</code> table reference
     */
    public RpkitChatGroup(Name alias) {
        this(alias, RPKIT_CHAT_GROUP);
    }

    /**
     * Create a <code>rpkit_chat.rpkit_chat_group</code> table reference
     */
    public RpkitChatGroup() {
        this(DSL.name("rpkit_chat_group"), null);
    }

    public <O extends Record> RpkitChatGroup(Table<O> child, ForeignKey<O, RpkitChatGroupRecord> key) {
        super(child, key, RPKIT_CHAT_GROUP);
    }

    @Override
    public Schema getSchema() {
        return RpkitChat.RPKIT_CHAT;
    }

    @Override
    public Identity<RpkitChatGroupRecord, Integer> getIdentity() {
        return (Identity<RpkitChatGroupRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitChatGroupRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CHAT_GROUP_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitChatGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitChatGroupRecord>>asList(Keys.KEY_RPKIT_CHAT_GROUP_PRIMARY);
    }

    @Override
    public RpkitChatGroup as(String alias) {
        return new RpkitChatGroup(DSL.name(alias), this);
    }

    @Override
    public RpkitChatGroup as(Name alias) {
        return new RpkitChatGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatGroup rename(String name) {
        return new RpkitChatGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatGroup rename(Name name) {
        return new RpkitChatGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}