package com.kookie;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KookieMod implements ModInitializer {
    public static final String MOD_ID = "kookie";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Registry key for the kookie item
    public static final RegistryKey<Item> KOOKIE_KEY = RegistryKey.of(
            RegistryKeys.ITEM,
            Identifier.of(MOD_ID, "kookie")
    );

    // The kookie item with special effects
    public static final Item KOOKIE = register(
            KOOKIE_KEY,
            new KookieItem(new Item.Settings()
                    .registryKey(KOOKIE_KEY)
                    .maxCount(64)
                    .food(KookieItem.KOOKIE_FOOD, KookieItem.KOOKIE_CONSUMABLE))
    );

    private static Item register(RegistryKey<Item> key, Item item) {
        return Registry.register(Registries.ITEM, key, item);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Kookie Mod initialized!");

        // Add kookie to the food item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.add(KOOKIE);
        });
    }
}
