package lemon.servlet;

import lemon.dao.StudentDAO;
import lemon.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName StudentQueryAsDictServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/7 21:22
 * @Version 2020.1
 **/
@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取班级id
        int id = Integer.parseInt(req.getParameter("dictionaryKey"));
        List<Student> students = StudentDAO.queryAsDict(id);
        return students;
    }
}
