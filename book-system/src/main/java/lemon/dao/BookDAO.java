package lemon.dao;

import lemon.exception.SystemException;
import lemon.model.Book;
import lemon.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookDAO
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/7 17:47
 * @Version 2020.1
 **/
public class BookDAO {
    public static List<Book> queryAsDict() {
        List<Book> books = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DBUtil.getConnection();
            String sql = "select id, book_name, author,price from book";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                book.setDictionaryTagValue(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                books.add(book);
            }
        }catch (Exception e){
            throw new SystemException("00004","查询图书数据字典出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return books;
    }
}
