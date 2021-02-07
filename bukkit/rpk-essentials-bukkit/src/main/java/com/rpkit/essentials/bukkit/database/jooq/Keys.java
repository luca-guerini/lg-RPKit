/*
 * This file is generated by jOOQ.
 */
package com.rpkit.essentials.bukkit.database.jooq;


import com.rpkit.essentials.bukkit.database.jooq.tables.FlywaySchemaHistoryPlayers;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitLogMessagesEnabled;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitPreviousLocation;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitTrackingDisabled;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.FlywaySchemaHistoryPlayersRecord;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.RpkitLogMessagesEnabledRecord;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.RpkitPreviousLocationRecord;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.RpkitTrackingDisabledRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * rpkit_essentials.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryPlayersRecord> KEY_FLYWAY_SCHEMA_HISTORY_PLAYERS_PRIMARY = Internal.createUniqueKey(FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS, DSL.name("KEY_flyway_schema_history_players_PRIMARY"), new TableField[] { FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS.INSTALLED_RANK }, true);
    public static final UniqueKey<RpkitLogMessagesEnabledRecord> KEY_RPKIT_LOG_MESSAGES_ENABLED_PRIMARY = Internal.createUniqueKey(RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED, DSL.name("KEY_rpkit_log_messages_enabled_PRIMARY"), new TableField[] { RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED.MINECRAFT_PROFILE_ID }, true);
    public static final UniqueKey<RpkitPreviousLocationRecord> KEY_RPKIT_PREVIOUS_LOCATION_PRIMARY = Internal.createUniqueKey(RpkitPreviousLocation.RPKIT_PREVIOUS_LOCATION, DSL.name("KEY_rpkit_previous_location_PRIMARY"), new TableField[] { RpkitPreviousLocation.RPKIT_PREVIOUS_LOCATION.MINECRAFT_PROFILE_ID }, true);
    public static final UniqueKey<RpkitTrackingDisabledRecord> KEY_RPKIT_TRACKING_DISABLED_PRIMARY = Internal.createUniqueKey(RpkitTrackingDisabled.RPKIT_TRACKING_DISABLED, DSL.name("KEY_rpkit_tracking_disabled_PRIMARY"), new TableField[] { RpkitTrackingDisabled.RPKIT_TRACKING_DISABLED.CHARACTER_ID }, true);
}