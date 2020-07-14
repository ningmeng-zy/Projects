package lemon.util;
import org.junit.Assert;
import org.junit.Test;
/**
 * @ClassName DBUtilTest
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:40
 * @Version 2020.1
 **/

public class DBUtilTest {
    @Test
    public void test(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
