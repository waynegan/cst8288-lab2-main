package org.cst8288Lab2.dao;

import org.cst8288Lab2.domain.Student;
import java.sql.SQLException;

/**
 * Data Access Object (DAO) interface for handling Student data.
 * Defines the standard operations to be performed on a Student model object.
 */
public interface StudentDAO {

    /**
     * Adds a new student to the database.
     * 
     * @param student the Student object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    void addStudent(Student student) throws SQLException;
}
