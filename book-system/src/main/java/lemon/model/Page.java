package lemon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Page
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/14 18:52
 * @Version 2020.1
 **/
@Getter
@Setter
@ToString
public class Page {
    private String searchText;
    private String sortOrder;
    private Integer pageSize;
    private Integer pageNumber;
}
