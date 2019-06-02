package model;

import java.util.List;

public class Classes {
    private Integer id;
    private String name;
    // �༶��ѧ����һ�Զ�Ĺ�ϵ����һ���༶�����ж��ѧ��
    private List<Student> students;

    public Classes() {

    }

    public Classes(Integer id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}