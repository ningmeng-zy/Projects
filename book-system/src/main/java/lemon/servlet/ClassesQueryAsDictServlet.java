package lemon.servlet;

import lemon.dao.ClassesDAO;
import lemon.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ClassesQueryAsDictServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/7 17:29
 * @Version 2020.1
 **/
@WebServlet("/classes/queryAsDict")
public class ClassesQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> classesList = ClassesDAO.queryAsDict();
        return classesList;
    }
}
