/*
 * This file is generated by jOOQ.
 */
package com.rpkit.craftingskill.bukkit.database.jooq;


import com.rpkit.craftingskill.bukkit.database.jooq.tables.RpkitCraftingExperience;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCraftingSkill extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_crafting_skill</code>
     */
    public static final RpkitCraftingSkill RPKIT_CRAFTING_SKILL = new RpkitCraftingSkill();

    /**
     * The table <code>rpkit_crafting_skill.rpkit_crafting_experience</code>.
     */
    public final RpkitCraftingExperience RPKIT_CRAFTING_EXPERIENCE = RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE;

    /**
     * No further instances allowed
     */
    private RpkitCraftingSkill() {
        super("rpkit_crafting_skill", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE);
    }
}