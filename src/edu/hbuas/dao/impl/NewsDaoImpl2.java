package edu.hbuas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import edu.hbuas.dao.NewsDao;
import edu.hbuas.dbutil.DBUTils;
import edu.hbuas.entity.News;

public class NewsDaoImpl2 implements NewsDao {
	QueryRunner qy=new QueryRunner(DBUTils.getDataSource());
	@Override
	public List<News> getallnews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addnews(News news) {
		// TODO Auto-generated method stub
		String sql="insert into news value (?,?,?,?,?,?,?,?,?)";
		Object[] params= {news.getNid(),news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcreateDate(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary()};
		System.out.println("qy添加！");
		try {
			return qy.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<News> getnewsbyntid(int ntid) {
		// TODO Auto-generated method stub
		String sql="select * from news where ntid=?";
		System.out.println("qy获取1！");
		try {
			return qy.query(sql, new BeanListHandler<>(News.class), ntid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deletenewbynid(int nid) {
		// TODO Auto-generated method stub
		String sql="delete from news where nid=?";
		System.out.println("qy删除！");
		try {
			return qy.update(sql, nid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public News getnewsbynid(int nid) {
		// TODO Auto-generated method stub
		String sql="select * from news where nid=?";
		System.out.println("qy获取2！");
		
		try {
			return qy.query(sql, new BeanHandler<>(News.class), nid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updatenews(News news) {
		// TODO Auto-generated method stub
		String sql="update news set ntid=? , ntitle=?,nauthor=?,ncontent=?,nmodifyDate=?,nsummary=? where nid=?";
		Object[] params= {news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary(),news.getNid()};
		System.out.println("qy更新！");
		try {
			return qy.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from news limit ?,?";
		System.out.println(sql);
		try {
		return qy.query(sql, new BeanListHandler<>(News.class), (pageIndex-1)*pageSize,pageSize);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return null;
	}

}
