package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

public class MoneyCaseReward extends CaseReward {

    private final double amount;

    public MoneyCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws, double amount) {
        super("money", chance, previewItemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
}