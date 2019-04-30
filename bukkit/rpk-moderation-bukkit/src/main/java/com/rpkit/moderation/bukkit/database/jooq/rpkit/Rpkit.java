/*
 * This file is generated by jOOQ.
*/
package com.rpkit.moderation.bukkit.database.jooq.rpkit;


import com.rpkit.moderation.bukkit.database.jooq.DefaultCatalog;
import com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitTicket;
import com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitVanishState;
import com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitWarning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Rpkit extends SchemaImpl {

    private static final long serialVersionUID = -1706128134;

    /**
     * The reference instance of <code>rpkit</code>
     */
    public static final Rpkit RPKIT = new Rpkit();

    /**
     * The table <code>rpkit.rpkit_ticket</code>.
     */
    public final RpkitTicket RPKIT_TICKET = com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitTicket.RPKIT_TICKET;

    /**
     * The table <code>rpkit.rpkit_vanish_state</code>.
     */
    public final RpkitVanishState RPKIT_VANISH_STATE = com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitVanishState.RPKIT_VANISH_STATE;

    /**
     * The table <code>rpkit.rpkit_warning</code>.
     */
    public final RpkitWarning RPKIT_WARNING = com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitWarning.RPKIT_WARNING;

    /**
     * No further instances allowed
     */
    private Rpkit() {
        super("rpkit", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            RpkitTicket.RPKIT_TICKET,
            RpkitVanishState.RPKIT_VANISH_STATE,
            RpkitWarning.RPKIT_WARNING);
    }
}