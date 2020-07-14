package lemon.servlet;

import lemon.dao.UserDAO;
import lemon.exception.BusinessException;
import lemon.model.User;
import lemon.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLoginServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 14:41
 * @Version 2020.1
 **/
@WebServlet("/user/login")
public class UserLoginServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //req.getParameter("")这个方式只能获取URL和请求体，k=v形式的数据
        User user = JSONUtil.read(req.getInputStream(),User.class);//http请求解析的用户数据
        User queryUser = UserDAO.query(user);//通过请求的用户名密码在数据库查询，获取用户
        if (queryUser == null){
            throw new BusinessException("00001","用户名密码校验失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",queryUser);
        return null;
    }
    /*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String uesrname = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("用户名=%s，密码=%s\n",uesrname,password);

        PrintWriter pw = resp.getWriter();
        pw.println("登录成功");
        pw.flush();
    }*/
}
