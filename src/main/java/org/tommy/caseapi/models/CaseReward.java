package org.tommy.caseapi.models;

import org.bukkit.inventory.ItemStack;

public abstract class CaseReward {

    protected final String type;
    protected final double chance;
    protected final ItemStack itemStack;
    protected final boolean withBroadcastMessage;
    private int index;

    private final boolean isLimited;
    private int maxDraws;
    private int remainingDraws;

    protected CaseReward(String type, double chance, ItemStack itemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws) {
        this.type = type;
        this.chance = chance;
        this.itemStack = itemStack;
        this.withBroadcastMessage = withBroadcastMessage;
        this.index = 0;
        this.isLimited = isLimited;
        this.maxDraws = maxDraws;
        this.remainingDraws = remainingDraws;
    }

    public String getType() {
        return type;
    }

    public double getChance() {
        return chance;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public boolean isWithBroadcastMessage() {
        return this.withBroadcastMessage;
    }

    public int getIndex() {
        return this.index;
    }

    public CaseReward setIndex(int index) {
        this.index = index;
        return this;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public boolean isAvailable() {
        return remainingDraws >= 1;
    }

    public int getMaxDraws() {
        return maxDraws;
    }

    public int getRemainingDraws() {
        return remainingDraws;
    }

    public void reduceRemainingDraws() {
        remainingDraws--;
    }

    public double getWinChance(double totalChance) {
        if (totalChance <= 0) return 0;
        return (this.chance / totalChance) * 100;
    }
}