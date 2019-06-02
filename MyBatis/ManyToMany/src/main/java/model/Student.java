package model;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private List<Course> courses; 

    public Student() {

    }

    public Student(Integer id, String name, String sex, Integer age,List<Course> courses) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
