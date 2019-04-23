package top.yuyufeng.demo.statement;


import top.yuyufeng.demo.utils.ConnetcionUtil;
import top.yuyufeng.demo.utils.ReleaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnetcionUtil.getConnection();
            String sql = "insert into user_info(user_id,user_name,age,create_time) "
                    + "values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, "yyf");
            preparedStatement.setInt(3, 25);
            preparedStatement.setDate(4,
                    new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }
}
