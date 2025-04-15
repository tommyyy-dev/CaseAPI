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
    private final long rawDuration;
    private final DurationUnit durationUnit;

    /**
     * Constructs a new {@code PermissionCaseReward} with the specified parameters.
     *
     * @param chance The probability of winning this reward.
     * @param previewItemStack The item used as a preview in the case.
     * @param withBroadcastMessage Whether a broadcast message is sent when this reward is won.
     * @param permission The permission granted upon winning.
     * @param duration The duration for which the permission is granted.
     * @param durationUnit The unit of the duration.
     */
    public PermissionCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, String permission, long duration, DurationUnit durationUnit) {
        super("permission", chance, previewItemStack, withBroadcastMessage);
        this.permission = permission;
        this.rawDuration = duration;
        this.durationUnit = durationUnit;
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
     * Gets the raw duration as a long.
     *
     * @return The raw duration as a long.
     */
    public long getRawDuration() {
        return this.rawDuration;
    }

    /**
     * Returns the {@link DurationUnit}
     *
     * @return The {@link DurationUnit}.
     */
    public DurationUnit getDurationUnit() {
        return this.durationUnit;
    }

    /**
     * Gets the {@link Duration} for which the permission is granted.
     *
     * @return The {@link Duration} of the permission.
     */
    public Duration getDuration() {
        return this.duration;
    }
}