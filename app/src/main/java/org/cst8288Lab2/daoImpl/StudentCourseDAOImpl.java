package org.cst8288Lab2.daoImpl;

import org.cst8288Lab2.dao.StudentCourseDAO;
import org.cst8288Lab2.domain.StudentCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementation class of the StudentCourseDAO interface for handling StudentCourse data in the database.
 */
public class StudentCourseDAOImpl implements StudentCourseDAO {

    private Connection connection;

    /**
     * Constructs a StudentCourseDAOImpl object with a database connection.
     * 
     * @param connection the database connection to be used
     */
    public StudentCourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adds a new student-course record to the database.
     * 
     * @param studentCourse the StudentCourse object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    @Override
    public void addStudentCourse(StudentCourse studentCourse) throws SQLException {
        String query = "INSERT INTO StudentCourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(studentCourse.getStudentId()));
            stmt.setString(2, studentCourse.getCourseId());
            stmt.setInt(3, studentCourse.getTerm().getValue());
            stmt.setInt(4, studentCourse.getYear());
            stmt.executeUpdate();
        }
    }

    // Other CRUD methods...
}
