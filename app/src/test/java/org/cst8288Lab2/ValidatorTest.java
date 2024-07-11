package org.cst8288Lab2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.cst8288Lab2.utils.Validator;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testValidStudentId() {
        assertTrue(Validator.isValidStudentId("123456789"));
    }

    @Test
    public void testInvalidStudentId() {
        assertFalse(Validator.isValidStudentId("123"));
        assertFalse(Validator.isValidStudentId("abcdefghij"));
    }

    @Test
    public void testValidName() {
        assertTrue(Validator.isValidName("John"));
    }

    @Test
    public void testInvalidName() {
        assertFalse(Validator.isValidName(""));
        assertFalse(Validator.isValidName(null));
    }

    @Test
    public void testValidCourseId() {
        assertTrue(Validator.isValidCourseId("CST8288"));
        assertTrue(Validator.isValidCourseId("cst8288"));
    }

    @Test
    public void testInvalidCourseId() {
        assertFalse(Validator.isValidCourseId("CST828"));
        assertFalse(Validator.isValidCourseId("1234567"));
    }

    @Test
    public void testValidCourseName() {
        assertTrue(Validator.isValidCourseName("Software Design Patterns"));
    }

    @Test
    public void testInvalidCourseName() {
        assertFalse(Validator.isValidCourseName(""));
        assertFalse(Validator.isValidCourseName(null));
    }

    @Test
    public void testValidTerm() {
        assertTrue(Validator.isValidTerm("WINTER"));
        assertTrue(Validator.isValidTerm("SUMMER"));
        assertTrue(Validator.isValidTerm("FALL"));
    }

    @Test
    public void testInvalidTerm() {
        assertFalse(Validator.isValidTerm("SPRING"));
    }

    @Test
    public void testValidYear() {
        assertTrue(Validator.isValidYear("2024"));
    }

    @Test
    public void testInvalidYear() {
        assertFalse(Validator.isValidYear("1800"));
        assertFalse(Validator.isValidYear("abcd"));
    }
}
