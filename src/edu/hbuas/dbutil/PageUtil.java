package edu.hbuas.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 分页帮助类
 * 
 * @author yanqi
 *
 */
public class PageUtil {
	/**
	 * 获取总记录数
	 * 
	 * @param tablename
	 * @return
	 */
	public static int count(String tablename) {
		int count = -1;
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			con = DBUtil2.getcon();
			String sql = "select count(1) from " + tablename;
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil2.closeAll(con, pre, rs);
		}
		return count;
	}

	/**
	 * 获取总页数
	 * 
	 * @param count
	 * @param pageSize
	 * @return
	 */
	public static int getTotalPages(int count, int pageSize) {

		return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}

}
