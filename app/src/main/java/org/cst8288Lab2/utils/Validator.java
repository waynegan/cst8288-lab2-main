package org.cst8288Lab2.utils;

import org.cst8288Lab2.domain.Term;

/**
 * Utility class for data validation.
 */
public class Validator {

    /**
     * Validates a student with the provided details.
     * 
     * @param studentId the student ID to validate
     * @param firstName the first name to validate
     * @param lastName the last name to validate
     * @return true if all fields are valid; false otherwise
     */
    public static boolean isValidStudent(String studentId, String firstName, String lastName) {
        return isValidStudentId(studentId) && isValidName(firstName) && isValidName(lastName);
    }

    /**
     * Validates a student ID.
     * 
     * @param studentId the student ID to validate
     * @return true if the student ID is valid; false otherwise
     */
    public static boolean isValidStudentId(String studentId) {
        return studentId != null && studentId.matches("\\d{9}");
    }

    /**
     * Validates a name.
     * 
     * @param name the name to validate
     * @return true if the name is valid; false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Validates a course with the provided details.
     * 
     * @param courseId the course ID to validate
     * @param courseName the course name to validate
     * @return true if all fields are valid; false otherwise
     */
    public static boolean isValidCourse(String courseId, String courseName) {
        return isValidCourseId(courseId) && isValidCourseName(courseName);
    }

    /**
     * Validates a course ID.
     * 
     * @param courseId the course ID to validate
     * @return true if the course ID is valid; false otherwise
     */
    public static boolean isValidCourseId(String courseId) {
        return courseId != null && courseId.matches("[A-Za-z]{3}\\d{4}");
    }

    /**
     * Validates a course name.
     * 
     * @param courseName the course name to validate
     * @return true if the course name is valid; false otherwise
     */
    public static boolean isValidCourseName(String courseName) {
        return courseName != null && !courseName.trim().isEmpty();
    }

    /**
     * Validates a term.
     * 
     * @param term the term to validate
     * @return true if the term is valid; false otherwise
     */
    public static boolean isValidTerm(String term) {
        try {
            Term.fromString(term);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Validates a year.
     * 
     * @param year the year to validate
     * @return true if the year is valid; false otherwise
     */
    public static boolean isValidYear(String year) {
        int foundingYear = 1967;
        try {
            int y = Integer.parseInt(year);
            int currentYear = java.time.LocalDate.now().getYear();
            return y >= foundingYear && y <= currentYear;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
