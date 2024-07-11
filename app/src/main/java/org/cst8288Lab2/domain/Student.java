package org.cst8288Lab2.domain;

/**
 * Represents a Student entity with studentId, firstName, and lastName attributes.
 */
public class Student {

    private String studentId;
    private String firstName;
    private String lastName;

    /**
     * Constructs a Student object with studentId, firstName, and lastName.
     * 
     * @param studentId the unique identifier of the student
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     */
    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the studentId of the student.
     * 
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the studentId of the student.
     * 
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Retrieves the firstName of the student.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName of the student.
     * 
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the lastName of the student.
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName of the student.
     * 
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
