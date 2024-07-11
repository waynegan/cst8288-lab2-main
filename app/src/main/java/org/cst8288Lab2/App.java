/*
 * Main application class for bulk data import into the LMS database.
 */
package org.cst8288Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.dao.StudentCourseDAO;
import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.daoImpl.CourseDAOImpl;
import org.cst8288Lab2.daoImpl.StudentCourseDAOImpl;
import org.cst8288Lab2.daoImpl.StudentDAOImpl;
import org.cst8288Lab2.database.DBConnection;
import org.cst8288Lab2.domain.Course;
import org.cst8288Lab2.domain.Student;
import org.cst8288Lab2.domain.StudentCourse;
import org.cst8288Lab2.domain.Term;
import org.cst8288Lab2.logger.LMSLogger;
import org.cst8288Lab2.utils.ReportGenerator;
import org.cst8288Lab2.utils.Validator;

/**
 * Main application class for bulk data import into the Learning Management System (LMS) database.
 */
public class App {

    private static final LMSLogger logger = LMSLogger.getInstance();

    /**
     * Main method to execute the bulk data import process.
     * Parses the file: bulk-import.csv
     * Validates each item in each row and updates the database accordingly.
     * Generates success and error reports after processing.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream in = new FileInputStream("./data/database.properties")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                properties.load(br);
                logger.info("Loaded database properties.");
            }
        } catch (IOException e) {
            logger.error("Failed to load database properties: " + e.getMessage());
            e.printStackTrace();
        }

        String url = "jdbc:" + properties.getProperty("db") + "://" + properties.getProperty("host") + ":"
                + properties.getProperty("port") + "/" + properties.getProperty("name");
        String user = properties.getProperty("user");
        String password = properties.getProperty("pass");

        try (Connection connection = DBConnection.getConnection(url, user, password)) {
            logger.info("Connected to the database.");

            StudentDAO studentDAO = new StudentDAOImpl(connection);
            CourseDAO courseDAO = new CourseDAOImpl(connection);
            StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl(connection);

            List<Student> validStudents = new ArrayList<>();
            List<Course> validCourses = new ArrayList<>();
            List<StudentCourse> validStudentCourses = new ArrayList<>();
            List<String> errorLines = new ArrayList<>();

            try (InputStream in = new FileInputStream("./data/bulk-import.csv")) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                    String line;
                    int lineNumber = 0;

                    while ((line = br.readLine()) != null) {
                        lineNumber++;
                        if (lineNumber == 1) {
                            continue; // Skip the header line
                        }

                        String[] fields = line.split(",");
                        if (fields.length != 7) {
                            errorLines.add("Line " + lineNumber + ": Invalid number of fields");
                            continue;
                        }

                        String studentId = fields[0].trim();
                        String firstName = fields[1].trim();
                        String lastName = fields[2].trim();
                        String courseId = fields[3].trim();
                        String courseName = fields[4].trim();
                        String termString = fields[5].trim();
                        String yearString = fields[6].trim();

                        boolean isValid = true;
                        StringBuilder errorBuilder = new StringBuilder("Line " + lineNumber + ": ");

                        if (!Validator.isValidStudentId(studentId)) {
                            isValid = false;
                            errorBuilder.append("Invalid studentId; ");
                            logger.debug("Line " + lineNumber + ": Invalid studentId - " + studentId);
                        }
                        if (!Validator.isValidName(firstName)) {
                            isValid = false;
                            errorBuilder.append("Invalid firstName; ");
                            logger.debug("Line " + lineNumber + ": Invalid firstName - " + firstName);
                        }
                        if (!Validator.isValidName(lastName)) {
                            isValid = false;
                            errorBuilder.append("Invalid lastName; ");
                            logger.debug("Line " + lineNumber + ": Invalid lastName - " + lastName);
                        }
                        if (!Validator.isValidCourseId(courseId)) {
                            isValid = false;
                            errorBuilder.append("Invalid courseId; ");
                            logger.debug("Line " + lineNumber + ": Invalid courseId - " + courseId);
                        }
                        if (!Validator.isValidCourseName(courseName)) {
                            isValid = false;
                            errorBuilder.append("Invalid courseName; ");
                            logger.debug("Line " + lineNumber + ": Invalid courseName - " + courseName);
                        }
                        if (!Validator.isValidTerm(termString)) {
                            isValid = false;
                            errorBuilder.append("Invalid term; ");
                            logger.debug("Line " + lineNumber + ": Invalid term - " + termString);
                        }
                        if (!Validator.isValidYear(yearString)) {
                            isValid = false;
                            errorBuilder.append("Invalid year; ");
                            logger.debug("Line " + lineNumber + ": Invalid year - " + yearString);
                        }

                        if (isValid) {
                            Student student = new Student(studentId, firstName, lastName);
                            Course course = new Course(courseId, courseName);
                            Term term = Term.fromString(termString);
                            int year = Integer.parseInt(yearString);
                            StudentCourse studentCourse = new StudentCourse(studentId, courseId, term, year);

                            validStudents.add(student);
                            validCourses.add(course);
                            validStudentCourses.add(studentCourse);
                        } else {
                            errorLines.add(errorBuilder.toString());
                            logger.warn(errorBuilder.toString());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Failed to read bulk-import.csv: " + e.getMessage());
            }

            // Insert valid records into the database
            int studentsAdded = 0;
            int coursesAdded = 0;
            int studentCoursesAdded = 0;

            for (Student student : validStudents) {
                try {
                    studentDAO.addStudent(student);
                    studentsAdded++;
                    logger.info("Added student to DB: " + student);
                } catch (Exception e) {
                    errorLines.add("Error adding student: " + student + " - " + e.getMessage());
                    logger.error("Error adding student: " + student + " - " + e.getMessage());
                }
            }

            for (Course course : validCourses) {
                try {
                    courseDAO.addCourse(course);
                    coursesAdded++;
                    logger.info("Added course to DB: " + course);
                } catch (Exception e) {
                    errorLines.add("Error adding course: " + course + " - " + e.getMessage());
                    logger.error("Error adding course: " + course + " - " + e.getMessage());
                }
            }

            for (StudentCourse studentCourse : validStudentCourses) {
                try {
                    studentCourseDAO.addStudentCourse(studentCourse);
                    studentCoursesAdded++;
                    logger.info("Added studentCourse to DB: " + studentCourse);

                } catch (Exception e) {
                    errorLines.add("Error adding studentCourse: " + studentCourse + " - " + e.getMessage());
                    logger.error("Error adding studentCourse: " + studentCourse + " - " + e.getMessage());
                }
            }

            // Generate reports
            String successReport = ReportGenerator.generateSuccessReport(studentsAdded, coursesAdded, studentCoursesAdded);
            String errorReport = ReportGenerator.generateErrorReport(errorLines);

            try (FileWriter successWriter = new FileWriter("./data/import-report.md");
                 FileWriter errorWriter = new FileWriter("./data/error-report.md")) {
                successWriter.write(successReport);
                errorWriter.write(errorReport);
                logger.info("Generated reports.");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Failed to generate reports: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Failed to connect to the database: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
            logger.close();
        }
    }
}
