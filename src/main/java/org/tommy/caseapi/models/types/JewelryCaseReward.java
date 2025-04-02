package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;


/**
 * Represents a reward that grants a certain amount of jewelry currency to the player upon winning.
 * The {@link ItemStack} is used as a preview item in the case.
 *
 * @author Tommyyy
 */
public class JewelryCaseReward extends CaseReward {

    private final double amount;

    /**
     * Constructs a new {@code JewelryCaseReward} with the specified parameters.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param amount The amount of jewelry currency granted upon winning.
     */
    protected JewelryCaseReward(int slot, double chance, ItemStack previewItemStack, double amount) {
        super(slot, chance, previewItemStack);
        this.amount = amount;
    }

    /**
     * Constructs a new {@code JewelryCaseReward} with the specified parameters, including a broadcast setting.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     * @param amount The amount of jewelry currency granted upon winning.
     */
    protected JewelryCaseReward(int slot, double chance, ItemStack previewItemStack, boolean withBroadcastMessage, double amount) {
        super(slot, chance, previewItemStack, withBroadcastMessage);
        this.amount = amount;
    }

    /**
     * Gets the amount of jewelry currency granted by this reward.
     *
     * @return The amount of jewelry currency.
     */
    public double getAmount() {
        return this.amount;
    }
}