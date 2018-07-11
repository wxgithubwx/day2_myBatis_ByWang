package wx.vo;

import wx.pojo.Book;

import java.util.List;

public class QueryVo {
    //封装Bean:Book
    private Book book;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
