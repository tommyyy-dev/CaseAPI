package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

/**
 * Represents a reward that grants an item to the player upon winning.
 * The {@link ItemStack} is used both as a preview item in the case and as the actual reward item.
 *
 * @author Tommyyy
 */
public class ItemCaseReward extends CaseReward {

    /**
     * Constructs a new {@code ItemCaseReward} with the specified parameters.
     *
     * @param chance The probability of winning this reward.
     * @param itemStack The item used both as a preview in the case and as the actual reward item.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     */
    public ItemCaseReward(double chance, ItemStack itemStack, boolean withBroadcastMessage) {
        super("item", chance, itemStack, withBroadcastMessage);
    }
}