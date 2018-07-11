package wx.mapper;

import wx.pojo.Book;
import wx.vo.QueryVo;

import java.util.List;

public interface BookMapper {
    public Book findBookByQueryVo(QueryVo queryVo);
    public int findBookCount();
    public List<Book> findAllBook();
    public List<Book> findBookByNameAndId(Book book);
    public List<Book> findBookByWhere(Book book);
    public List<Book> findBookByForeach(QueryVo queryVo);
    public List<Book> findBookBySql(QueryVo queryVo);
}
