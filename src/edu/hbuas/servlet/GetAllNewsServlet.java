package edu.hbuas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hbuas.dao.NewsDao;
import edu.hbuas.dbutil.PageUtil;
import edu.hbuas.entity.News;
import edu.hbuas.entity.Topic;
import edu.hbuas.service.NewsService;
import edu.hbuas.service.TopicService;
import edu.hbuas.service.impl.NewsServiceImpl;
import edu.hbuas.service.impl.TopicServiceImpl;

/**
 * Servlet implementation class GetAllNewsServlet
 */
@WebServlet("/admin/GetAllNews")
public class GetAllNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllNewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 假定每页显示3条信息
		int pageSize = 3;
		// 获取当前页码
		String cuurentPage = request.getParameter("pageIndex");
		if (cuurentPage==null) {
			cuurentPage = "1";
		}
		int pageIndex = Integer.parseInt(cuurentPage);
		// 总记录数
		int count = PageUtil.count("news");
		// 总页数
		int totalPages = PageUtil.getTotalPages(count, pageSize);

		//页面超出解决
		if(pageIndex<=0) {
			pageIndex=1;
		}
		if(pageIndex>totalPages) {
			pageIndex=totalPages;
		}
		// 获取新闻
		NewsService ns = new NewsServiceImpl();
		//List<News> allnews = ns.getallnews();
		List<News> pagenews=ns.getNewsByPage(pageIndex, pageSize);
		// 获取所有标题
		TopicService ts = new TopicServiceImpl();
		List<Topic> alltopic = ts.getalltopic();
		HttpSession session = request.getSession();
		// 存放到session中
		session.setAttribute("pagenews", pagenews);
		session.setAttribute("alltopic", alltopic);
		session.setAttribute("totalPages", totalPages);
		session.setAttribute("pageIndex", pageIndex);
		// 重定向
		// response.sendRedirect("show_news.jsp");
		request.getRequestDispatcher("/admin/show_news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
