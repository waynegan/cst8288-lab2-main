package org.cst8288Lab2.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Utility class to generate import and error reports.
 */
public class ReportGenerator {

    /**
     * Generates a success report with the number of records added.
     * 
     * @param studentsAdded the number of students added
     * @param coursesAdded the number of courses added
     * @param studentCoursesAdded the number of student courses added
     * @return a formatted success report
     */
    public static String generateSuccessReport(int studentsAdded, int coursesAdded, int studentCoursesAdded) {
        StringBuilder sb = new StringBuilder();
        sb.append("# Import Report\n");
        sb.append("## Date and Time\n");
        sb.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        sb.append("## Records Added\n");
        sb.append("- Students: ").append(studentsAdded).append("\n");
        sb.append("- Courses: ").append(coursesAdded).append("\n");
        sb.append("- Student Courses: ").append(studentCoursesAdded).append("\n");
        return sb.toString();
    }

    /**
     * Generates an error report listing lines that failed to import.
     * 
     * @param errorLines the list of error lines
     * @return a formatted error report
     */
    public static String generateErrorReport(List<String> errorLines) {
        StringBuilder sb = new StringBuilder();
        sb.append("# Error Report\n");
        for (String error : errorLines) {
            sb.append(error).append("\n");
        }
        return sb.toString();
    }
}
