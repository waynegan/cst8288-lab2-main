package org.cst8288Lab2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Singleton logger class for logging messages to a file.
 */
public class LMSLogger {

    private static LMSLogger loggerInstance = null;
    private static PrintWriter writer;
    private LogLevel currentLogLevel = LogLevel.INFO; // Default log level

    /**
     * Private constructor to initialize the logger instance and the log file.
     */
    private LMSLogger() {
        try {
            writer = new PrintWriter(new FileWriter("app.log", true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    /**
     * Retrieves the singleton instance of the logger.
     * 
     * @return the singleton instance of LMSLogger
     */
    public static LMSLogger getInstance() {
        if (loggerInstance == null) {
            synchronized (LMSLogger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new LMSLogger();
                }
            }
        }
        return loggerInstance;
    }

    /**
     * Sets the current log level.
     * 
     * @param level the LogLevel to set
     */
    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    /**
     * Logs a message with the specified log level.
     * 
     * @param level the LogLevel of the log message
     * @param message the log message
     */
    public void log(LogLevel level, String message) {
        System.out.println(level + ": " + message);
        writer.println(level + ": " + message);
    }

    /**
     * Logs a TRACE level message.
     * 
     * @param message the log message
     */
    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    /**
     * Logs a DEBUG level message.
     * 
     * @param message the log message
     */
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    /**
     * Logs an INFO level message.
     * 
     * @param message the log message
     */
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Logs a WARN level message.
     * 
     * @param message the log message
     */
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    /**
     * Logs an ERROR level message.
     * 
     * @param message the log message
     */
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * Closes the logger, flushing and closing the underlying PrintWriter.
     */
    public void close() {
        writer.close();
    }

}
