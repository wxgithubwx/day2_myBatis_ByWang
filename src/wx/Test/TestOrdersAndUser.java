package wx.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wx.mapper.OrderMapper;
import wx.pojo.Orders;
import wx.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestOrdersAndUser {
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private InputStream inputStream;
    private  String resource="config/SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void createSqlSession() throws IOException {
        sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     * 1对1
     */
    @Test
    public void TestSelectOrders(){
        sqlSession=sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = mapper.selectOrders();
        for (Orders o:
                orders) {
            System.out.println(o.toString());
        }
    }

    /**
     * 1对多
     */
    @Test
    public void TestSelectUser(){
        sqlSession=sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<User> users = mapper.selectUser();
        for (User u: users) {
            System.out.println(u.toString());
        }


    }

    @After
    public void closeSqlSession(){
        //关闭
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}
