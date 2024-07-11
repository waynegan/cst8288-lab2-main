package org.cst8288Lab2.dao;

import org.cst8288Lab2.domain.StudentCourse;
import java.sql.SQLException;

/**
 * Data Access Object (DAO) interface for handling StudentCourse data.
 * Defines the standard operations to be performed on a StudentCourse model object.
 */
public interface StudentCourseDAO {

    /**
     * Adds a new student-course record to the database.
     * 
     * @param studentCourse the StudentCourse object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    void addStudentCourse(StudentCourse studentCourse) throws SQLException;
    
    // Other CRUD methods...
}
