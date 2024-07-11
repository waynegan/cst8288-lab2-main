package org.cst8288Lab2.logger;

/**
 * Enum representing log levels: TRACE, DEBUG, INFO, WARN, ERROR.
 */
public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    final int level;

    /**
     * Constructor to set the integer value of the log level.
     * 
     * @param level the integer value representing the log level
     */
    LogLevel(int level) {
        this.level = level;
    }
}
