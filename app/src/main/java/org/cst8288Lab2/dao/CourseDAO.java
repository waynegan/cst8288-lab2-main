package org.cst8288Lab2.dao;

import java.sql.SQLException;
import org.cst8288Lab2.domain.Course;

/**
 * Data Access Object (DAO) interface for handling Course data.
 * Defines the standard operations to be performed on a Course model object.
 */
public interface CourseDAO {

    /**
     * Adds a new course to the database.
     * 
     * @param course the Course object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    void addCourse(Course course) throws SQLException;
}