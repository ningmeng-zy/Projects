package lemon.servlet;

import lemon.exception.BaseException;
import lemon.model.ResponseResult;
import lemon.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * @ClassName AbstractBaseServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:50
 * @Version 2020.1
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //针对请求体设置编码，注意对url中的请求数据无效
        req.setCharacterEncoding("UTF-8");
        //针对响应体设置编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应
        resp.setContentType("application/json");
        ResponseResult r = new ResponseResult();

        try {
            //父类的service调用doGet/doPost方法，
            //只要
            Object data = process(req,resp);
            r.setSuccess(true);
            r.setCode("200");
            r.setMessage("操作成功");
            r.setData(data);
        } catch (Exception e) {//process抛异常处理逻辑
            e.printStackTrace();
            if (e instanceof BaseException) {
                BaseException be = (BaseException) e;
                r.setCode(be.getCode());
                r.setMessage(be.getMessage());
            }else {
                r.setCode("500");
                r.setMessage("未知的错误");
            }
            //设置堆栈信息
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            r.setStackTrace(sw.toString());
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(r));
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp)throws Exception;
}
