package edu.hbuas.service;

import java.util.List;

import edu.hbuas.entity.News;

public interface NewsService {
	List<News> getallnews();
	boolean addnews(News news);
	boolean deletenewsbynid(int nid);
	News getnewsbynid(int nid);
	boolean updatenews(News news);
	List<News> getNewsByPage(int pageIndex,int pageSize);//当前页码pageInex，每页显示的条数
	
}
