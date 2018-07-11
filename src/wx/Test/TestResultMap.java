package wx.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wx.mapper.GradeMapper;
import wx.pojo.Book;
import wx.mapper.BookMapper;
import wx.pojo.Grade;
import wx.vo.QueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestResultMap {
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

    @Test
    public void findAllBook(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> allBook = mapper.findAllBook();
        for (Book b:allBook) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void findBookByNameAndId(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book=new Book();
        book.setName("冰心");
        List<Book> allBook = mapper.findBookByNameAndId(book);
        for (Book b:allBook) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void findBookByWhere(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book=new Book();
        book.setName("鲁迅");
        List<Book> allBook = mapper.findBookByWhere(book);
        for (Book b:allBook) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void findBookByForeach(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book=new Book();
        book.setName("爱");
        QueryVo queryVo=new QueryVo();
        ArrayList<Integer> ids=new ArrayList<>();
        ids.add(14);
        ids.add(20);
        queryVo.setIds(ids);
        queryVo.setBook(book);
        List<Book> allBook = mapper.findBookByForeach(queryVo);
        for (Book b:allBook) {
            System.out.println(b.toString());
        }
    }

    /**
     * 测试sql片段
     */
    @Test
    public void findBookBySql(){
        sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book=new Book();
        book.setName("的");
        QueryVo queryVo=new QueryVo();
        ArrayList<Integer> ids=new ArrayList<>();
        ids.add(14);
        ids.add(20);
        queryVo.setIds(ids);
        queryVo.setBook(book);
        List<Book> allBook = mapper.findBookByForeach(queryVo);
        for (Book b:allBook) {
            System.out.println(b.toString());
        }
    }


    @Test
    public void findGrade(){
        sqlSession=sqlSessionFactory.openSession();
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        List<Grade> grade = mapper.findGrade();
        for (Grade g:grade
             ) {
            System.out.println(g.toString());
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
