package test;

import mapper.StudentMapper;
import model.Course;
import model.Student;
import model.StudentCourseLink;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        // Mybatis �����ļ�
        String resource = "mybatis.cfg.xml";

        // �õ������ļ���
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // �����Ự���������� MyBatis �������ļ���Ϣ
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        selectStudentCourse();
//        deleteStudentCourseById();

    }

    // ��ѯ����ѧ�������ǵ�ѡ��γ̵���Ϣ
    private static void selectStudentCourse(){
        // ͨ�������õ� SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            List<Student> students = mapper.selectStudentCourse();
            session.commit();
            for(Student stu:students){
                System.out.println(stu.getId()+","+stu.getName()+","+stu.getSex()+","+stu.getAge()+":");
                List<Course> courses = stu.getCourses();
                for(Course cou:courses){
                    System.out.println(cou.getId()+","+cou.getName()+","+cou.getCredit());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // �ͷ���Դ
        session.close();
    }

    // ����ѧ��id�Ϳγ�idɾ����ѧ�����ſε�ѡ�����
    private static void deleteStudentCourseById(){
        SqlSession session = sqlSessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            Student student = new Student();
            student.setId(1);
            Course course = new Course();
            course.setId(2);
            StudentCourseLink scLink = new StudentCourseLink();
            scLink.setStudent(student);
            scLink.setCourse(course);
            mapper.deleteStudentCourseById(scLink);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }
}