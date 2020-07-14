package lemon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 班级表
 */
@Getter
@Setter
@ToString
public class Classes extends DictionaryTag{
    
    private Integer id;

    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 毕业年份，数据字典000001
     */
    private String classesGraduateYear;

    /**
     * 专业，数据字典000002
     */
    private String classesMajor;

    /**
     * 备注
     */
    private String classesDesc;

    /**
     * 创建时间
     */
    private Date createTime;
}