package org.cst8288Lab2.domain;

/**
 * Represents a Course entity with courseId and courseName attributes.
 */
public class Course {

    private String courseId;
    private String courseName;

    /**
     * Constructs a Course object with courseId and courseName.
     * 
     * @param courseId the unique identifier of the course
     * @param courseName the name of the course
     */
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    /**
     * Retrieves the courseId of the course.
     * 
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the courseId of the course.
     * 
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Retrieves the courseName of the course.
     * 
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the courseName of the course.
     * 
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
