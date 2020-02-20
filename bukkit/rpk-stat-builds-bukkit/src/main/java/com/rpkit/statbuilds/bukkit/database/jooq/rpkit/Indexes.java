/*
 * This file is generated by jOOQ.
 */
package com.rpkit.statbuilds.bukkit.database.jooq.rpkit;


import com.rpkit.statbuilds.bukkit.database.jooq.rpkit.tables.RpkitCharacterStatPoints;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index RPKIT_CHARACTER_STAT_POINTS_PRIMARY = Indexes0.RPKIT_CHARACTER_STAT_POINTS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index RPKIT_CHARACTER_STAT_POINTS_PRIMARY = Internal.createIndex("PRIMARY", RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS, new OrderField[] { RpkitCharacterStatPoints.RPKIT_CHARACTER_STAT_POINTS.ID }, true);
    }
}
