package top.yuyufeng.demo.statement;

import top.yuyufeng.demo.utils.ConnetcionUtil;
import top.yuyufeng.demo.utils.ReleaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author yuyufeng
 * @date 2019/1/11.
 */
public class TestResult {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // 1. 获取Connection
            conn = ConnetcionUtil.getConnection();
            // 2. 获取Statement
            statement = conn.createStatement();
            // 3. 准备SQL
            String sql = "select user_id,user_name,age,create_time from user_info ";

            // 4.执行查询得到result
            rs = statement.executeQuery(sql);
            // 5.处理ResultSet
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                Integer age = rs.getInt("age");
                Date createIime = rs.getDate("create_time");

                System.out.println(userId + " " + userName + " " + age + " " + createIime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(rs, statement, conn);
        }

    }
}
