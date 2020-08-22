package edu.hbuas.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUTils {
	// 创建一个ThreadLoacl对象，用当前线程作为key
	private static ThreadLocal<Connection> tc = new ThreadLocal<>();
	// 读取的是C3P0-config默认配置创建数据库连接池对象
	private static DataSource ds = new ComboPooledDataSource("mysql");

	// 获取数据库连接池对象
	public static DataSource getDataSource() {
		return ds;
	}

	// 从连接池中获取连接
	public static Connection getConnection() throws SQLException {
		Connection conn = tc.get();
		if (conn == null) {
			conn = ds.getConnection();
			// 将conn存放到集合tc中
			tc.set(conn);
			System.out.println("首次创建连接：" + conn);
		}
		return conn;
	}

	// 开启事务
	public static void startTransaction() {
		try {
			// 获取连接
			Connection conn = getConnection();
			// 开启事务
			/*
			 * setAutoCommit总的来说就是保持数据的完整性，一个系统的更新操作可能要涉及多张表，需多个SQL语句进行操作
			 * 循环里连续的进行插入操作，如果你在开始时设置了：conn.setAutoCommit(false);
			 * 最后才进行conn.commit(),这样你即使插入的时候报错，修改的内容也不会提交到数据库，
			 */
			conn.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit() {
		try {
			Connection conn = tc.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback() {
		try {
			// 从集合tc中得到一个连接
			Connection conn = tc.get();
			if (conn != null) {
				// 该方法用于取消在当前事务中进行的更改，并释放当前Connection对象持有的所有数据库锁。此方法只有在手动事务模式下才可用
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
