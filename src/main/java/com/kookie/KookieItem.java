package com.kookie;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.world.World;

import java.util.List;

public class KookieItem extends Item {

    // Food component for the kookie - restores same as regular cookie
    public static final FoodComponent KOOKIE_FOOD = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.1f)
            .build();

    // Consumable component with the special effects
    public static final ConsumableComponent KOOKIE_CONSUMABLE = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            // Speed II (amplifier 1) for 3 minutes (3600 ticks)
                            new StatusEffectInstance(StatusEffects.SPEED, 3600, 1),
                            // Regeneration II (amplifier 1) for 30 seconds (600 ticks)
                            new StatusEffectInstance(StatusEffects.REGENERATION, 3600, 1)
                    ),
                    1.0f // 100% chance to apply effects
            ))
            .build();

    public KookieItem(Settings settings) {
        super(settings.consumable(KOOKIE_CONSUMABLE));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // The effects are automatically applied by the consumable component
        return super.finishUsing(stack, world, user);
    }
}
