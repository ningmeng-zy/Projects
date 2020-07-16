package lemon.servlet;

import lemon.dao.BorrowRecordDAO;
import lemon.model.BorrowRecord;
import lemon.model.Page;
import lemon.util.Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName BorrowRecordQueryServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 18:58
 * @Version 2020.1
 **/
@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Page p = Util.parse(req);

        List<BorrowRecord> records = BorrowRecordDAO.query(p);
        return records;
    }
}
