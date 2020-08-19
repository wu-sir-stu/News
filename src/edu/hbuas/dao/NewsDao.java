package edu.hbuas.dao;

import java.util.List;

import edu.hbuas.entity.News;

public interface NewsDao {

	List<News> getallnews();//获取所有的news
	int addnews(News news);//添加news
	List<News> getnewsbyntid(int ntid);//根据ntid获取news
	int deletenewbynid(int nid);//根据nid删除news
	News getnewsbynid(int nid);//根据nid获取news
	int updatenews(News news);//根据nid修改news
	List<News> getNewsByPage(int pageIndex,int pageSize);//当前页码pageInex，每页显示的条数
	
}
