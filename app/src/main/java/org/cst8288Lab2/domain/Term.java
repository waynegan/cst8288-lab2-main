package org.cst8288Lab2.domain;

/**
 * Enum representing academic terms: Winter, Summer, and Fall.
 */
public enum Term {
    WINTER(1), SUMMER(2), FALL(3);

    private final int value;

    /**
     * Constructor to set the integer value of the enum.
     * 
     * @param value the integer value of the term
     */
    Term(int value) {
        this.value = value;
    }

    /**
     * Gets the integer value of the term.
     * 
     * @return the integer value of the term
     */
    public int getValue() {
        return value;
    }

    /**
     * Converts a string representation of a term to its corresponding Term enum value.
     * 
     * @param term the string representation of the term (case insensitive)
     * @return the corresponding Term enum
     * @throws IllegalArgumentException if the term string is unknown or invalid
     */
    public static Term fromString(String term) {
        switch (term.toUpperCase()) {
            case "WINTER":
                return WINTER;
            case "SUMMER":
                return SUMMER;
            case "FALL":
                return FALL;
            default:
                throw new IllegalArgumentException("Unknown term: " + term);
        }
    }
}
