package edu.hbuas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hbuas.entity.News;
import edu.hbuas.entity.Topic;
import edu.hbuas.service.NewsService;
import edu.hbuas.service.TopicService;
import edu.hbuas.service.impl.NewsServiceImpl;
import edu.hbuas.service.impl.TopicServiceImpl;

/**
 * Servlet implementation class GetNewsBynidServlet
 */
@WebServlet("/admin/GetNewsBynid")
public class GetNewsBynidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNewsBynidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int nid=Integer.parseInt(request.getParameter("nid"));
		NewsService ns=new NewsServiceImpl();
		News getnews=ns.getnewsbynid(nid);
		TopicService topicService=new TopicServiceImpl();
		List<Topic> alltopics2=topicService.getalltopic();
		HttpSession session=request.getSession();
		session.setAttribute("getnews", getnews);
		session.setAttribute("alltopics2", alltopics2);
		//重定向
		response.sendRedirect("update_news.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
