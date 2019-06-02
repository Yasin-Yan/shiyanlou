package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.ClassesMapper;
import model.Classes;

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
            Classes classes = mapper.selectClassById(1);
            session.commit();
            System.out.println(classes.getId() + "," + classes.getName() + ",["
                    + classes.getTeacher().getId() + ","
                    + classes.getTeacher().getName() + ","
                    + classes.getTeacher().getAge()+"]");

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // �ͷ���Դ
        session.close();

    }
}