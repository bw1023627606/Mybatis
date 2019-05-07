import com.bw.dao.OrderDao;
import com.bw.dao.UserDao;
import com.bw.entity.Order;
import com.bw.entity.User;
import org.apache.ibatis.io.Resources;
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
 * @data 2019/5/6 - 16:13
 * @description
 */
public class TestOrder {
    @Test
    public void testGetAllOrder(){
        {
            //读取配置文件
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("userMapConfig.xml");
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                SqlSession sqlSession = sqlSessionFactory.openSession();
                OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
                List<Order> list= orderDao.getAllOrder();
                for (Order order : list) {
                    System.out.println(order);
                }
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testGetOrderIf(){
        {
            //读取配置文件
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("userMapConfig.xml");
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                SqlSession sqlSession = sqlSessionFactory.openSession();
                OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
                Order order = new Order();

                User user = new User();
                user.setId(10);
                order.setUser(user);
                List<Order> list= orderDao.getOrderIf(order);
                for (Order order1 : list) {
                    System.out.println(order1);
                    System.out.println(order1.getUser());
                }
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
