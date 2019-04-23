package top.yuyufeng.demo.connection;

import com.alibaba.druid.pool.DruidDataSource;
import top.yuyufeng.demo.config.DBProperties;

import java.sql.Connection;

/**
 * @author yuyufeng
 * @date 2019/1/11.
 */
public class DruidUtil {

    public static Connection getConnection() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DBProperties.getDriverClassName());

        druidDataSource.setUsername(DBProperties.getUsername());
        druidDataSource.setPassword(DBProperties.getPassword());
        druidDataSource.setUrl(DBProperties.getUrl());

       /* druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(3);
        druidDataSource.setMaxActive(20);

        druidDataSource.setMaxWait(60000);

        druidDataSource.init();*/
        Connection connection = druidDataSource.getConnection();
        return connection;
    }
}
