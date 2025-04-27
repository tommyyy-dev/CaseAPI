package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

public class GemsCaseReward extends CaseReward {

    private final int amount;

    public GemsCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws, int amount) {
        super("gems", chance, previewItemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}