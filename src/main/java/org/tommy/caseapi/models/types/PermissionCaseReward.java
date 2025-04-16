package org.tommy.caseapi.models.types;

import org.bukkit.inventory.ItemStack;
import org.tommy.caseapi.models.CaseReward;
import org.tommy.caseapi.models.DurationUnit;
import org.tommy.caseapi.utils.DurationUtil;

import java.time.Duration;

public class PermissionCaseReward extends CaseReward {

    private final String permission;
    private final Duration duration;
    private final long rawDuration;
    private final DurationUnit durationUnit;

    public PermissionCaseReward(double chance, ItemStack previewItemStack, boolean withBroadcastMessage, boolean isLimited, int maxDraws, int remainingDraws, String permission, long duration, DurationUnit durationUnit) {
        super("permission", chance, previewItemStack, withBroadcastMessage, isLimited, maxDraws, remainingDraws);
        this.permission = permission;
        this.rawDuration = duration;
        this.durationUnit = durationUnit;
        this.duration = DurationUtil.getDuration(duration, durationUnit);
    }

    public String getPermission() {
        return this.permission;
    }

    public long getRawDuration() {
        return this.rawDuration;
    }

    public DurationUnit getDurationUnit() {
        return this.durationUnit;
    }

    public Duration getDuration() {
        return this.duration;
    }
}