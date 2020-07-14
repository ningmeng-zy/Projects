package lemon.util;

import lemon.model.ResponseResult;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
/**
 * @ClassName JSONUtilTest
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/6 17:44
 * @Version 2020.1
 **/
public class JSONUtilTest {
    @Test
    public void testRead(){
        InputStream is = getClass().getClassLoader().getResourceAsStream("response.json");
        ResponseResult r = JSONUtil.read(is,ResponseResult.class);
        System.out.println(r);
        Assert.assertNotNull(r);
    }
    @Test
    public void testWrite(){
        ResponseResult r = new ResponseResult();
        r.setCode("K3000");
        r.setMessage("lemon3000");
        r.setSuccess(true);
        r.setTotal(9);
        String s = JSONUtil.write(r);
        System.out.println(s);
        Assert.assertNotNull(s);
        Assert.assertTrue(s.trim().length()>0);
    }
}

