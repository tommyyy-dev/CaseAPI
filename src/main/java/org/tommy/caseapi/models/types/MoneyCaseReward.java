package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

/**
 * Represents a reward that grants a certain amount of in-game currency to the player upon winning.
 * The {@link ItemStack} is used as a preview item in the case.
 *
 * @author Tommyyy
 */
public class MoneyCaseReward extends CaseReward {

    private final double amount;

    /**
     * Constructs a new {@code MoneyCaseReward} with the specified parameters.
     *
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     * @param amount The amount of in-game currency granted upon winning.
     */
    public MoneyCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, double amount) {
        super("money", chance, previewItemStack, withBroadcastMessage);
        this.amount = amount;
    }

    /**
     * Gets the amount of in-game currency granted by this reward.
     *
     * @return The amount of currency.
     */
    public double getAmount() {
        return this.amount;
    }
}