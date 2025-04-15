package org.tommy.caseapi.models;

import java.time.Duration;

/**
 * Represents different units of time for duration calculation.
 * Provides methods for converting time units to {@link Duration}.
 *
 * @author Tommyyy
 */
public enum DurationUnit {

    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS;

    /**
     * Converts a string representation of a time unit to the corresponding {@link DurationUnit}.
     *
     * @param s The string representation of the time unit (e.g., "seconds", "minutes").
     * @return The corresponding {@link DurationUnit} or {@code null} if the string does not match a valid enum value.
     */
    public static DurationUnit fromString(String s) {
        try {
            return DurationUnit.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("(!) The enum type \"" + s.toUpperCase() + "\" doesn't exist in the enum \"DurationUnit\"");
            return null;
        }
    }
}