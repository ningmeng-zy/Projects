package lemon.servlet;

import lemon.dao.BorrowRecordDAO;
import lemon.exception.BusinessException;
import lemon.model.BorrowRecord;
import lemon.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BorrowRecordAddServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/10 20:28
 * @Version 2020.1
 **/
@WebServlet("/borrowRecord/delete")
public class BorrowRecordDeleteServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");
        int num = BorrowRecordDAO.delete(ids);
        if (num != ids.length){
            throw new BusinessException("00010","删除图书借阅信息异常");
        }
        return null;
    }
}
