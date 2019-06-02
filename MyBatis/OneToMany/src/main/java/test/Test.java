package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

import mapper.ClassesMapper;
import model.Classes;
import model.Student;


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

        // ͨ�������õ� SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        ClassesMapper mapper = session.getMapper(ClassesMapper.class);
        try {
            Classes classes = mapper.selectClassAndStudentsById(1);
            session.commit();
            System.out.println("�༶��Ϣ��"+classes.getId()+","+classes.getName());
            List<Student> students = classes.getStudents();
            System.out.println("�༶������ѧ����Ϣ��");
             for(Student stu:students){
                 System.out.println(stu.getId()+","+stu.getName()+","+stu.getSex()+","+stu.getAge());
             }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        // �ͷ���Դ
        session.close();
    }
}