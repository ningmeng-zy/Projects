package lemon.util;

import lemon.model.Page;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Util
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/14 19:09
 * @Version 2020.1
 **/
public class Util {
    public static Page parse(HttpServletRequest req){
        Page p = new Page();
        p.setSearchText(req.getParameter("searchText"));
        p.setSortOrder(req.getParameter("sortOrder"));
        p.setPageSize(Integer.parseInt(req.getParameter("pageSize")));
        p.setPageNumber(Integer.parseInt(req.getParameter("pageNumber")));
        return p;
    }
}
