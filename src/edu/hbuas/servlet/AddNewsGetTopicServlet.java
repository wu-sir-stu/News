package edu.hbuas.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AddNewsGetTopicServlet
 */
@WebServlet("/admin/AddNewsGetTopic")
public class AddNewsGetTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsGetTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		TopicService topicService=new TopicServiceImpl();
        HttpSession session=request.getSession();
        List<Topic> addnewstopic=topicService.getalltopic();
        session.setAttribute("addnewstopic",addnewstopic);
        request.getRequestDispatcher("/admin/add_news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
