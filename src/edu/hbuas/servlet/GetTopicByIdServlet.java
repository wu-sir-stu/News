package edu.hbuas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hbuas.entity.Topic;
import edu.hbuas.service.TopicService;
import edu.hbuas.service.impl.TopicServiceImpl;

/**
 * Servlet implementation class GetTopicByIdServlet
 */
@WebServlet("/admin/GetTopicById")
public class GetTopicByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopicByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(request.getParameter("tid"));
		TopicService ts=new TopicServiceImpl();
		Topic utopic=ts.getbytid(tid);
		//将信息保存到session
        HttpSession session=request.getSession();
        session.setAttribute("utopic",utopic);
		request.getRequestDispatcher("/admin/update_topic.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
