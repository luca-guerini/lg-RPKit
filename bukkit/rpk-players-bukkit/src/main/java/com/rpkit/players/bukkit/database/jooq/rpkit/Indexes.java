/*
 * This file is generated by jOOQ.
*/
package com.rpkit.players.bukkit.database.jooq.rpkit;


import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitGithubProfile;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitIrcProfile;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitMinecraftProfile;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitMinecraftProfileLinkRequest;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitMinecraftProfileToken;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitPlayer;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitProfile;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index RPKIT_GITHUB_PROFILE_PRIMARY = Indexes0.RPKIT_GITHUB_PROFILE_PRIMARY;
    public static final Index RPKIT_IRC_PROFILE_PRIMARY = Indexes0.RPKIT_IRC_PROFILE_PRIMARY;
    public static final Index RPKIT_MINECRAFT_PROFILE_PRIMARY = Indexes0.RPKIT_MINECRAFT_PROFILE_PRIMARY;
    public static final Index RPKIT_MINECRAFT_PROFILE_LINK_REQUEST_PRIMARY = Indexes0.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST_PRIMARY;
    public static final Index RPKIT_MINECRAFT_PROFILE_TOKEN_PRIMARY = Indexes0.RPKIT_MINECRAFT_PROFILE_TOKEN_PRIMARY;
    public static final Index RPKIT_PLAYER_PRIMARY = Indexes0.RPKIT_PLAYER_PRIMARY;
    public static final Index RPKIT_PROFILE_PRIMARY = Indexes0.RPKIT_PROFILE_PRIMARY;
    public static final Index RPKIT_PROFILE_UK_RPKIT_PROFILE_NAME = Indexes0.RPKIT_PROFILE_UK_RPKIT_PROFILE_NAME;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index RPKIT_GITHUB_PROFILE_PRIMARY = createIndex("PRIMARY", RpkitGithubProfile.RPKIT_GITHUB_PROFILE, new OrderField[] { RpkitGithubProfile.RPKIT_GITHUB_PROFILE.ID }, true);
        public static Index RPKIT_IRC_PROFILE_PRIMARY = createIndex("PRIMARY", RpkitIrcProfile.RPKIT_IRC_PROFILE, new OrderField[] { RpkitIrcProfile.RPKIT_IRC_PROFILE.ID }, true);
        public static Index RPKIT_MINECRAFT_PROFILE_PRIMARY = createIndex("PRIMARY", RpkitMinecraftProfile.RPKIT_MINECRAFT_PROFILE, new OrderField[] { RpkitMinecraftProfile.RPKIT_MINECRAFT_PROFILE.ID }, true);
        public static Index RPKIT_MINECRAFT_PROFILE_LINK_REQUEST_PRIMARY = createIndex("PRIMARY", RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST, new OrderField[] { RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID }, true);
        public static Index RPKIT_MINECRAFT_PROFILE_TOKEN_PRIMARY = createIndex("PRIMARY", RpkitMinecraftProfileToken.RPKIT_MINECRAFT_PROFILE_TOKEN, new OrderField[] { RpkitMinecraftProfileToken.RPKIT_MINECRAFT_PROFILE_TOKEN.ID }, true);
        public static Index RPKIT_PLAYER_PRIMARY = createIndex("PRIMARY", RpkitPlayer.RPKIT_PLAYER, new OrderField[] { RpkitPlayer.RPKIT_PLAYER.ID }, true);
        public static Index RPKIT_PROFILE_PRIMARY = createIndex("PRIMARY", RpkitProfile.RPKIT_PROFILE, new OrderField[] { RpkitProfile.RPKIT_PROFILE.ID }, true);
        public static Index RPKIT_PROFILE_UK_RPKIT_PROFILE_NAME = createIndex("uk_rpkit_profile_name", RpkitProfile.RPKIT_PROFILE, new OrderField[] { RpkitProfile.RPKIT_PROFILE.NAME }, true);
    }
}