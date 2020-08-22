package edu.hbuas.dbutil;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.hbuas.entity.News;
import edu.hbuas.servlet.GetNewsBynidServlet;

public class test {
	static QueryRunner qy=new QueryRunner(DBUTils.getDataSource());
	public static void main(String[] args) {

		List<News> news=getNewsByPage(1, 3);
		System.out.println(news.size());
		for(News n:news) {
			System.out.println(n.toString());
		}
	}

	public static List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from news limit ?,?";
		System.out.println(sql);
		try {
			return qy.query(sql, new BeanListHandler<>(News.class), (pageIndex - 1) * pageSize, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
