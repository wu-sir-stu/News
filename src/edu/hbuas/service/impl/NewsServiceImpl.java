package edu.hbuas.service.impl;

import java.util.List;

import edu.hbuas.dao.NewsDao;
import edu.hbuas.dao.impl.NewsDaoImpl;
import edu.hbuas.dao.impl.NewsDaoImpl2;
import edu.hbuas.entity.News;
import edu.hbuas.service.NewsService;

public class NewsServiceImpl implements NewsService {

	//添加数据持久层依赖
	NewsDao nd=new NewsDaoImpl2();
	@Override
	public List<News> getallnews() {
		// TODO Auto-generated method stub
		return nd.getallnews();
	}
	@Override
	public boolean addnews(News news) {
		// TODO Auto-generated method stub
		return nd.addnews(news)>0;
	}
	@Override
	public boolean deletenewsbynid(int nid) {
		// TODO Auto-generated method stub
		return nd.deletenewbynid(nid)>0;
	}
	@Override
	public News getnewsbynid(int nid) {
		// TODO Auto-generated method stub
		return nd.getnewsbynid(nid);
	}
	@Override
	public boolean updatenews(News news) {
		// TODO Auto-generated method stub
		return nd.updatenews(news)>0;
	}
	@Override
	public List<News> getNewsByPage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return nd.getNewsByPage(pageIndex, pageSize);
	}

}
