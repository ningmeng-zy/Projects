package lemon.dao;

import lemon.exception.SystemException;
import lemon.model.Student;
import lemon.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDAO
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/7 21:23
 * @Version 2020.1
 **/
public class StudentDAO {

    public static List<Student> queryAsDict(int id) {
        List<Student> students = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = DBUtil.getConnection();
            String sql = "select id,student_name,id_card,student_no from student where classes_id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student  = new Student();
                student.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                student.setDictionaryTagValue(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard(rs.getString("id_card"));
                students.add(student);
            }
        }catch (Exception e){
            throw new SystemException("00005","查询学生数据字典出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return students;
    }
}
