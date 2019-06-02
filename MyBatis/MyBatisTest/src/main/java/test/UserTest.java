package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.UserMapper;
import model.User;

public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        // Mybatis 配置文件
        String resource = "mybatis.cfg.xml";

        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        insertUser();
//         updateUser();
//         deleteUser();
//         selectUserById();
         selectAllUser();

    }

    // 新增用戶
    private static void insertUser() {
        // 通过工厂得到 SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        user.setSex("male");
        user.setAddress("chengdu");
        try {
            mapper.insertUser(user);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // 释放资源
        session.close();
    }

    // 更新用戶
    private static void updateUser() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.selectUserById(1);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        user.setAddress("chongqing");
        try {
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // 删除用戶
    private static void deleteUser() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(3);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // 根据id查询用户信息
    private static void selectUserById() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            User user = mapper.selectUserById(1);
            session.commit();
            System.out.println(user.getId() + " " + user.getUsername() + " "
                    + user.getPassword() + " " + user.getSex() + " "
                    + user.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // 查询所有的用户信息
    private static void selectAllUser() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<User> userList = mapper.selectAllUser();
            session.commit();
            for (User user : userList) {
                System.out.println(user.getId() + " " + user.getUsername() + " "
                        + user.getPassword() + " " + user.getSex() + " "
                        + user.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }
}