package top.yuyufeng.demo.utils;

import top.yuyufeng.demo.connection.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class ConnetcionUtil {

    public static Connection getConnection() throws Exception {
        return DruidUtil.getConnection();

    }

    public static void beginTx(Connection connection) {

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
