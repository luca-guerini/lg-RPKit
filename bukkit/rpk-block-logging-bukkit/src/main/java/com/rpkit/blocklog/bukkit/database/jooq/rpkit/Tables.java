/*
 * Copyright 2017 Ross Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is generated by jOOQ.
*/
package com.rpkit.blocklog.bukkit.database.jooq.rpkit;


import com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.RpkitBlockChange;
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.RpkitBlockHistory;
import com.rpkit.blocklog.bukkit.database.jooq.rpkit.tables.RpkitBlockInventoryChange;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in rpkit
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>rpkit.rpkit_block_change</code>.
     */
    public static final RpkitBlockChange RPKIT_BLOCK_CHANGE = RpkitBlockChange.RPKIT_BLOCK_CHANGE;

    /**
     * The table <code>rpkit.rpkit_block_history</code>.
     */
    public static final RpkitBlockHistory RPKIT_BLOCK_HISTORY = RpkitBlockHistory.RPKIT_BLOCK_HISTORY;

    /**
     * The table <code>rpkit.rpkit_block_inventory_change</code>.
     */
    public static final RpkitBlockInventoryChange RPKIT_BLOCK_INVENTORY_CHANGE = RpkitBlockInventoryChange.RPKIT_BLOCK_INVENTORY_CHANGE;
}