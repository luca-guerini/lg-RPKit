/*
 * This file is generated by jOOQ.
*/
package com.rpkit.chat.bukkit.database.jooq.rpkit.tables;


import com.rpkit.chat.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.chat.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.records.RpkitChatGroupRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitChatGroup extends TableImpl<RpkitChatGroupRecord> {

    private static final long serialVersionUID = 465868187;

    /**
     * The reference instance of <code>rpkit.rpkit_chat_group</code>
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
     * The column <code>rpkit.rpkit_chat_group.id</code>.
     */
    public final TableField<RpkitChatGroupRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit.rpkit_chat_group.name</code>.
     */
    public final TableField<RpkitChatGroupRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "");

    /**
     * Create a <code>rpkit.rpkit_chat_group</code> table reference
     */
    public RpkitChatGroup() {
        this("rpkit_chat_group", null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_chat_group</code> table reference
     */
    public RpkitChatGroup(String alias) {
        this(alias, RPKIT_CHAT_GROUP);
    }

    private RpkitChatGroup(String alias, Table<RpkitChatGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitChatGroup(String alias, Table<RpkitChatGroupRecord> aliased, Field<?>[] parameters) {
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
    public Identity<RpkitChatGroupRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_CHAT_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitChatGroupRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CHAT_GROUP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitChatGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitChatGroupRecord>>asList(Keys.KEY_RPKIT_CHAT_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitChatGroup as(String alias) {
        return new RpkitChatGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatGroup rename(String name) {
        return new RpkitChatGroup(name, null);
    }
}