package lemon.dao;


import lemon.exception.SystemException;
import lemon.model.Book;
import lemon.model.BorrowRecord;
import lemon.model.Classes;
import lemon.model.Student;
import lemon.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName BorrowRecordDAO
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 19:06
 * @Version 2020.1
 **/
public class BorrowRecordDAO {
    public static List<BorrowRecord> query() {
        List<BorrowRecord> records = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "SELECT br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       b.book_name," +
                    "       b.author," +
                    "       b.price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "   FROM borrow_record br" +
                    "         JOIN book b ON br.book_id = b.id" +
                    "         JOIN student s ON br.student_id = s.id" +
                    "         JOIN classes c ON s.classes_id = c.id";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                //设置图书借阅信息
                BorrowRecord br = new BorrowRecord();
                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));
                br.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                //设置图书信息
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);
                //设置学生信息
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);
                //设置班级信息
                Classes classes = new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                br.setClasses(classes);
                records.add(br);
            }
        }catch (Exception e){
            throw new SystemException("00001", "查询图书借阅信息出错", e);
        }finally {
            DBUtil.close(c, ps, rs);
        }
        return records;
    }

    public static BorrowRecord queryById(int id) {
        //图书借阅信息
        BorrowRecord br = new BorrowRecord();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "SELECT br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       b.book_name," +
                    "       b.author," +
                    "       b.price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "   FROM borrow_record br" +
                    "         JOIN book b ON br.book_id = b.id" +
                    "         JOIN student s ON br.student_id = s.id" +
                    "         JOIN classes c ON s.classes_id = c.id" +
                    "   WHERE br.id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){

                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));
                br.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                //设置图书信息
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);
                //设置学生信息
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);
                //设置班级信息
                Classes classes = new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                br.setClasses(classes);
            }
        }catch (Exception e){
            throw new SystemException("00006", "查询图书借阅信息详情出错", e);
        }finally {
            DBUtil.close(c, ps, rs);
        }
        return br;
    }

    public static int insert(BorrowRecord record) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            String sql = "insert borrow_record(book_id, student_id, start_time, end_time) values (?, ?, ?, ?)";
            ps = c.prepareStatement(sql);
            ps.setInt(1,record.getBookId());
            ps.setInt(2,record.getStudentId());
            ps.setTimestamp(3,new Timestamp(record.getStartTime().getTime()));
            ps.setTimestamp(4,new Timestamp(record.getEndTime().getTime()));
            return ps.executeUpdate();
        }catch (Exception e){
            throw new SystemException("000011","插入图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int update(BorrowRecord record) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            String sql = "update borrow_record set book_id=?, student_id=?, start_time=?, end_time=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,record.getBookId());
            ps.setInt(2,record.getStudentId());
            ps.setTimestamp(3,new Timestamp(record.getStartTime().getTime()));
            ps.setTimestamp(4,new Timestamp(record.getEndTime().getTime()));
            ps.setInt(5,record.getId());
            return ps.executeUpdate();
        }catch (Exception e){
            throw new SystemException("000012","修改图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int delete(String[] ids) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from borrow_record where id in (");
            for(int i=0;i<ids.length;i++){
                if (i != 0){
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");
            ps = c.prepareStatement(sql.toString());
            for(int i=0;i<ids.length;i++){
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }
            return ps.executeUpdate();
        }catch (Exception e){
            throw new SystemException("000013","删除图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

}
