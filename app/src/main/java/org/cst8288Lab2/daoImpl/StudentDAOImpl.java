package org.cst8288Lab2.daoImpl;

import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementation class of the StudentDAO interface for handling Student data in the database.
 */
public class StudentDAOImpl implements StudentDAO {

    private Connection connection;

    /**
     * Constructs a StudentDAOImpl object with a database connection.
     * 
     * @param connection the database connection to be used
     */
    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adds a new student to the database.
     * 
     * @param student the Student object to be added to the database
     * @throws SQLException if there is an error while accessing the database
     */
    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (studentId, firstName, lastName) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(student.getStudentId()));
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.executeUpdate();
        }
    }
}
