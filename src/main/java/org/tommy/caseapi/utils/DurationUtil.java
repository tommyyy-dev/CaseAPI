package org.tommy.caseapi.utils;

import org.tommy.caseapi.models.DurationUnit;

import java.time.Duration;

/**
 * Utility class for working with time durations and converting them to {@link Duration}.
 * Provides methods for calculating durations based on different time units.
 *
 * @author Tommyyy
 */
public class DurationUtil {

    /**
     * Converts a given amount and {@link DurationUnit} to a corresponding {@link Duration}.
     * The result represents the total duration in the specified unit.
     *
     * @param amount The amount of time.
     * @param unit The {@link DurationUnit} that specifies the time unit (e.g., SECONDS, MINUTES, etc.).
     * @return The corresponding {@link Duration}.
     */
    public static Duration getDuration(long amount, DurationUnit unit) {
        if (unit == null) return Duration.ZERO;
        return switch (unit) {
            case SECONDS -> Duration.ofSeconds(amount);
            case MINUTES -> Duration.ofMinutes(amount);
            case HOURS -> Duration.ofHours(amount);
            case DAYS -> Duration.ofDays(amount);
            case WEEKS -> Duration.ofDays(amount * 7);
            case MONTHS -> Duration.ofDays(amount * 30);
            case YEARS -> Duration.ofDays(amount * 365);
            default -> Duration.ZERO;
        };
    }
}