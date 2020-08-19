package edu.hbuas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hbuas.dao.NewsDao;
import edu.hbuas.dbutil.DBUtil2;
import edu.hbuas.entity.News;

public class NewsDaoImpl implements NewsDao {
	
	public List<News> Querynews(String sql, Object... params) {
		List<News> qnews = new ArrayList<>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			con = DBUtil2.getcon();
			pre = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pre.setObject(i + 1, params[i]);
				}
			}
			rs = pre.executeQuery();
			while (rs.next()) {
				News news=new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNpicPath(rs.getString("npicPath"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNsummary(rs.getString("nsummary"));
				qnews.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil2.closeAll(con, pre, rs);

		}
		return qnews;
	}

	@Override
	public List<News> getallnews() {
		// TODO Auto-generated method stub
		
		String sql="select * from news";
		List<News> allnews=Querynews(sql);
		return allnews;
	}

	@Override
	public int addnews(News news) {
		// TODO Auto-generated method stub
		String sql="insert into news value (?,?,?,?,?,?,?,?,?)";
		Object[] params= {news.getNid(),news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcreateDate(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary()};
		int r=DBUtil2.executeUpdate(sql, params);
		return r;
	}

	@Override
	public List<News> getnewsbyntid(int ntid) {
		// TODO Auto-generated method stub
		String sql="select * from news where ntid=?";
		List<News> ntidnews=Querynews(sql, ntid);
		return ntidnews;
	}

	@Override
	public int deletenewbynid(int nid) {
		// TODO Auto-generated method stub
		String sql="delete from news where nid=?";
		Object[] params= {nid};
		int r=DBUtil2.executeUpdate(sql, params);
		return r;
	}

	@Override
	public News getnewsbynid(int nid) {
		// TODO Auto-generated method stub
		News getnews=null;
		String sql="select * from news where nid=?";
		Object[] params= {nid};
		List<News> nidnews=Querynews(sql, params);
		if(nidnews.size()>0) {
			getnews=nidnews.get(0);
		}
		return getnews;
	}

	@Override
	public int updatenews(News news) {
		// TODO Auto-generated method stub
		String sql="update news set ntid=? , ntitle=?,nauthor=?,ncontent=?,nmodifyDate=?,nsummary=? where nid=?";
		Object[] params= {news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary(),news.getNid()};
		int r=DBUtil2.executeUpdate(sql, params);
		
		return r;
	}

	@Override
	public List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		int startindex=(pageIndex-1)*pageSize;
		String sql="select * from news limit ?,?";
		Object[] params= {startindex,pageSize};
		return Querynews(sql, params);
	}

}
