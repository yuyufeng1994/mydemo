package top.yuyufeng.demo.connection;

/**
 * @author yuyufeng
 * @date 2019/1/11.
 */
public class ConnectionPoolTest {
    public static void main(String[] args) throws Exception {
        System.out.println(DruidUtil.getConnection());
        System.out.println(DruidUtil.getConnection());
        System.out.println(DruidUtil.getConnection());
        System.out.println(DruidUtil.getConnection());
        System.out.println(DruidUtil.getConnection());
    }
}
