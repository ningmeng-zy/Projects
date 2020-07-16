package lemon.util;

/**
 * @ClassName CountHolder
 * @Description TODO
 * @Author 张洋
 * @Date 2020/7/14 20:20
 * @Version 2020.1
 **/
public class CountHolder {
    private static final ThreadLocal<Integer> COUNT = new ThreadLocal<>();

    public static void set(Integer count){
        COUNT.set(count);
    }
    public static Integer get(){
        return COUNT.get();
    }
    public static void remove(){
        COUNT.remove();
    }
}
