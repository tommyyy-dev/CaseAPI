package org.tommy.caseapi.models;

public enum DurationUnit {

    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS,
    INFINITE;

    public static DurationUnit fromString(String s) {
        try {
            return DurationUnit.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("(!) The enum type \"" + s.toUpperCase() + "\" doesn't exist in the enum \"DurationUnit\"");
            return null;
        }
    }
}