package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

public class JewelryCaseReward extends CaseReward {

    private final int amount;

    public JewelryCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws, int amount) {
        super("jewelry", chance, previewItemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}