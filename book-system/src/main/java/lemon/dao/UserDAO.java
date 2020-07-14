package lemon.dao;

import lemon.exception.SystemException;
import lemon.model.User;
import lemon.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/10 19:13
 * @Version 2020.1
 **/
public class UserDAO {

    public static User query(User user) {
        User queryUser = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DBUtil.getConnection();
            String sql = "select id,username,password,nickname from user where username=? and password=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()){
                queryUser = user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
            }
        }catch (Exception e){
            throw new SystemException("00007","用户登录校验数据库查询出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return queryUser;
    }
}
