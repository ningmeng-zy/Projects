package lemon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 图书借阅信息
 */
@Getter
@Setter
@ToString
public class BorrowRecord {
    
    private Integer id;

    /**
     * 图书id
     */
    private Integer bookId;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 借阅日期
     */
    private Date startTime;

    /**
     * 归还日期
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private Book book;

    private Classes classes;

    private Student student;
}