package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

public class ItemCaseReward extends CaseReward {

    public ItemCaseReward(double chance, ItemStack itemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws) {
        super("item", chance, itemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
    }
}