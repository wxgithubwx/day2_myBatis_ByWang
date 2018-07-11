package wx.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wx.pojo.Book;
import wx.mapper.BookMapper;
import wx.vo.QueryVo;

import java.io.IOException;
import java.io.InputStream;

public class TestBookMapper {
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private InputStream inputStream;
    private  String resource="config/SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

   /* public void closeSqlSession(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }*/

    @Before
    public void createSqlSession() throws IOException {
        sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
    }


    /**
     * 根据id查询单个
     */
    @Test
    public void findBookByQueryVo(){
         sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        //内层包装
        Book book=new Book();
        book.setId(11);
        //外层包装
        QueryVo queryVo=new QueryVo();
        queryVo.setBook(book);
        //操作sql
        Book findbook=mapper.findBookByQueryVo(queryVo);
        //输出
        System.out.println(findbook.toString());

    }

    //查询总数
    @Test
    public void findBookCount(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int bookCount = mapper.findBookCount();
        System.out.println("book表中记录总数"+bookCount);
    }

    @Test
    public void findAllBook(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

    }

    @After
    public void closeSqlSession(){
        //关闭
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
