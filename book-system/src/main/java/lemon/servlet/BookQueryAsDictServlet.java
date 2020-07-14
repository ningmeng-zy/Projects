package lemon.servlet;

import lemon.dao.BookDAO;
import lemon.model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName BookQueryAsDictServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/7 17:43
 * @Version 2020.1
 **/
@WebServlet("/book/queryAsDict")
public class BookQueryAsDictServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Book> books = BookDAO.queryAsDict();
        return books;
    }
}
