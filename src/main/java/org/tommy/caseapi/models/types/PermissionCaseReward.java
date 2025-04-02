package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;
import org.tommy.caseapi.models.DurationUnit;
import org.tommy.caseapi.utils.DurationUtil;

import java.time.Duration;

/**
 * Represents a reward that grants a permission to the player upon winning.
 * The {@link ItemStack} is used as a preview item in the case.
 *
 * @author Tommyyy
 */
public class PermissionCaseReward extends CaseReward {

    private final String permission;
    private final Duration duration;

    /**
     * Constructs a new {@code PermissionCaseReward} with the specified parameters.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param permission The permission granted upon winning.
     * @param duration The duration for which the permission is granted.
     * @param durationUnit The unit of the duration.
     */
    protected PermissionCaseReward(int slot, double chance, ItemStack previewItemStack, String permission, long duration, DurationUnit durationUnit) {
        super(slot, chance, previewItemStack);
        this.permission = permission;
        this.duration = DurationUtil.getDuration(duration, durationUnit);
    }

    /**
     * Constructs a new {@code PermissionCaseReward} with the specified parameters, including a broadcast setting.
     *
     * @param slot The slot in which the reward is displayed.
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     * @param permission The permission granted upon winning.
     * @param duration The duration for which the permission is granted.
     * @param durationUnit The unit of the duration.
     */
    protected PermissionCaseReward(int slot, double chance, ItemStack previewItemStack, boolean withBroadcastMessage, String permission, long duration, DurationUnit durationUnit) {
        super(slot, chance, previewItemStack, withBroadcastMessage);
        this.permission = permission;
        this.duration = DurationUtil.getDuration(duration, durationUnit);
    }

    /**
     * Gets the permission granted by this reward.
     *
     * @return The permission string.
     */
    public String getPermission() {
        return this.permission;
    }

    /**
     * Gets the duration for which the permission is granted.
     *
     * @return The duration of the permission.
     */
    public Duration getDuration() {
        return this.duration;
    }
}