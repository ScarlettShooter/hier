package com.scrl0.hier.utility;

import com.scrl0.hier.items.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MaterialType {

    COPPER("copper", 0, 2, 2, 255, 6.0F, 2.0F, 33, new int[] {4, 5, 8, 3}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () ->Ingredient.fromItems(ModItems.copper_ingot));

    private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
    private final String type;
    private final int harvestLevel;
    private final float hardness;
    private final float resistance;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repair;

    private MaterialType(String type, int harvestLevel, float hardness, float resistance, int maxUses, float efficiency, float attackDamage, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
        this.type = type;
        this.harvestLevel = harvestLevel;
        this.hardness = hardness;
        this.resistance = resistance;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repair = new LazyValue<Ingredient>(supplier);
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return enchantability;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return repair.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getType() {
        return type;
    }

    public float getToughness() {
        return toughness;
    }
}
