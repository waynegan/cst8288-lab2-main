package org.cst8288Lab2.domain;

/**
 * Represents a StudentCourse entity with studentId, courseId, term, and year attributes.
 */
public class StudentCourse {

    private String studentId;
    private String courseId;
    private Term term;
    private int year;

    /**
     * Constructs a StudentCourse object with studentId, courseId, term, and year.
     * 
     * @param studentId the unique identifier of the student
     * @param courseId the unique identifier of the course
     * @param term the academic term (Winter, Summer, Fall)
     * @param year the academic year
     */
    public StudentCourse(String studentId, String courseId, Term term, int year) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.term = term;
        this.year = year;
    }

    /**
     * Retrieves the studentId of the student associated with this StudentCourse.
     * 
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the studentId of the student associated with this StudentCourse.
     * 
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Retrieves the courseId of the course associated with this StudentCourse.
     * 
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the courseId of the course associated with this StudentCourse.
     * 
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Retrieves the academic term (Winter, Summer, Fall) of this StudentCourse.
     * 
     * @return the term
     */
    public Term getTerm() {
        return term;
    }

    /**
     * Sets the academic term (Winter, Summer, Fall) of this StudentCourse.
     * 
     * @param term the term to set
     */
    public void setTerm(Term term) {
        this.term = term;
    }

    /**
     * Retrieves the academic year of this StudentCourse.
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the academic year of this StudentCourse.
     * 
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
}
