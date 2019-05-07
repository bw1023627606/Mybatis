import com.bw.dao.UserDao;
import com.bw.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @auther bai
 * @data 2019/5/6 - 15:26
 * @description
 */
public class TestUser {
    @Test
    public void testGetUserById(){
        //读取配置文件
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("userMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUserById(1);
            System.out.println(user);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetAllUser(){
        //读取配置文件
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("userMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> list = userDao.getAllUser();
            for(User user:list){
                System.out.println(user);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetPageUser(){
        //读取配置文件
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("userMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            int offset = (2-1)*3;
            int limit = 3;
            RowBounds rowBounds = new RowBounds(offset,limit);
            List<User> list = sqlSession.selectList("com.bw.dao.UserDao.getAllUser", null, rowBounds);
            for (User user : list) {
                System.out.println(user);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetUserReturnId(){
        //读取配置文件
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("userMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User();
            user.setUsername("马小花");
            user.setBirthday(new Date());
            user.setAddress("安德门1");
            user.setSex("女");
            userDao.insertUser(user);
            System.out.println(user);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
