package lemon.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/10 19:44
 * @Version 2020.1
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //HttpServletRequest req = request;
        HttpServletRequest req  = (HttpServletRequest)request;
        String uri = req.getServletPath();
        if (!"/login.html".equals(uri) && !uri.startsWith("/public/") && !uri.startsWith("/static/")
                && !"/user/login".equals(uri)){//访问敏感资源
//            chain.doFilter(request,response);//这里没有哈，加上就报错。这个意思是跳转到下一个过滤器
            HttpSession session = req.getSession(false);
            if (session == null) {//访问敏感资源，没有登录，需要跳转到登录页面
                String schema = req.getScheme();//HTTP
                String host = req.getServerName();//服务器ip和域名
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + contextPath;
                ((HttpServletResponse) response).sendRedirect(basePath + "/public/index.html");
                return;
            }
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
