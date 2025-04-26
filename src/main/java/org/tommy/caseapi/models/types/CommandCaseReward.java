package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;

public class CommandCaseReward extends CaseReward {

    private final String command;

    public CommandCaseReward(double chance, ItemStack itemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws, String command) {
        super("command", chance, itemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}