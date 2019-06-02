package model;

import java.util.Date;

public class StudentCourseLink {
    private Student student;
    private Course course;
    private Date date;

    public StudentCourseLink() {

    }

    public StudentCourseLink(Student student, Course course, Date date) {
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}