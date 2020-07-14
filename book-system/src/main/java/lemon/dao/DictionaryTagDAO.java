package lemon.dao;

import lemon.exception.SystemException;
import lemon.model.DictionaryTag;
import lemon.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DictionaryTagDAO
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 20:09
 * @Version 2020.1
 **/
public class DictionaryTagDAO {
    public static List<DictionaryTag> query(String key) {
        List<DictionaryTag> tags = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DBUtil.getConnection();
            String sql = "SELECT concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   FROM dictionary d" +
                    "         JOIN dictionary_tag dt ON d.id = dt.dictionary_id" +
                    "   WHERE d.dictionary_key = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                tags.add(tag);
            }
        }catch (Exception e){
            throw new SystemException("00002","查询数据字典信息出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return tags;
    }
}
