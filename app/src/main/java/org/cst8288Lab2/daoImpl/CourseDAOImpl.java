package org.cst8288Lab2.daoImpl;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.domain.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementation class of the CourseDAO interface for handling Course data in the database.
 */
public class CourseDAOImpl implements CourseDAO {

    private Connection connection;

    /**
     * Constructs a CourseDAOImpl object with a database connection.
     * 
     * @param connection the database connection to be used
     */
    public CourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adds a new course to the database.
     * 
     * @param course the Course object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    @Override
    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Course (courseId, courseName) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.executeUpdate();
        }
    }

    // Other CRUD methods...
}
