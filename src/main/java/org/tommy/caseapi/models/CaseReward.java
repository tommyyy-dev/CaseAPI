package org.tommy.caseapi.models;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a reward that can be obtained from a case.
 * The {@link ItemStack} is always used as a preview item in the case.
 * If an implementation explicitly allows it, such as {@code ItemCaseReward},
 * the item can also be won as a reward.
 *
 * @author Tommyyy
 */
public abstract class CaseReward {

    protected final int slot;
    protected final double chance;
    protected final ItemStack itemStack;
    protected final boolean withBroadcastMessage;

    /**
     * Constructs a new {@code CaseReward} with the specified slot, chance, and item.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param itemStack The item used as a preview in the case.
     */
    protected CaseReward(int slot, double chance, ItemStack itemStack) {
        this.slot = slot;
        this.chance = chance;
        this.itemStack = itemStack;
        this.withBroadcastMessage = false;
    }

    /**
     * Constructs a new {@code CaseReward} with the specified slot, chance, item, and broadcast setting.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param itemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     */
    protected CaseReward(int slot, double chance, ItemStack itemStack, boolean withBroadcastMessage) {
        this.slot = slot;
        this.chance = chance;
        this.itemStack = itemStack;
        this.withBroadcastMessage = withBroadcastMessage;
    }

    /**
     * Gets the slot in which this reward is displayed.
     *
     * @return The slot number.
     */
    public int getSlot() {
        return this.slot;
    }

    /**
     * Gets the item stack that represents this reward.
     * This item is always used as a preview in the case.
     *
     * @return The item stack.
     */
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    /**
     * Checks whether this reward triggers a broadcast message when won.
     *
     * @return {@code true} if a broadcast message is sent, {@code false} otherwise.
     */
    public boolean isWithBroadcastMessage() {
        return this.withBroadcastMessage;
    }

    /**
     * Calculates the winning probability of this reward based on the total chance pool.
     *
     * @param totalChance The sum of all reward chances in the case.
     * @return The percentage chance of winning this reward, or {@code 0} if {@code totalChance} is invalid.
     */
    public double getWinChance(double totalChance) {
        if (totalChance <= 0) return 0;
        return (this.chance / totalChance) * 100;
    }
}