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

    protected final String type;
    protected final double chance;
    protected final ItemStack itemStack;
    protected final boolean withBroadcastMessage;
    private int index;

    /**
     * Constructs a new {@code CaseReward} with the specified chance, item, and broadcast setting.
     *
     * @param type The {@code CaseReward} type as a String.
     * @param chance The probability of winning this reward.
     * @param itemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     */
    protected CaseReward(String type, double chance, ItemStack itemStack, boolean withBroadcastMessage) {
        this.type = type;
        this.chance = chance;
        this.itemStack = itemStack;
        this.withBroadcastMessage = withBroadcastMessage;
        this.index = 0;
    }

    /**
     * Returns the {@code CaseReward} type.
     *
     * @return The {@code CaseReward} type.
     */
    public String getType() {
        return type;
    }



    /**
     * Returns the chance which was specified by a player.
     *
     * @return The chance which was specified.
     */
    public double getChance() {
        return chance;
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
     * Gets the index of this reward in the list of rewards.
     * This index determines the position of this reward in the case's reward pool.
     *
     * @return The index of the reward.
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Sets the index of this reward.
     * This allows you to update the position of this reward in the case's reward pool.
     *
     * @param index The new index of the reward.
     *
     * @return The {@link CaseReward} instance.
     */
    public CaseReward setIndex(int index) {
        this.index = index;
        return this;
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