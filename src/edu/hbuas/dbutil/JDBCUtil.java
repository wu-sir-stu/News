package edu.hbuas.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    private DataSource dataSource = null;

    public static class Holder {
        private static JDBCUtil instance = new JDBCUtil();
    }

    public static JDBCUtil getIns() {
        return Holder.instance;
    }

    public JDBCUtil() {
        dataSource = new ComboPooledDataSource("mysql");
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
