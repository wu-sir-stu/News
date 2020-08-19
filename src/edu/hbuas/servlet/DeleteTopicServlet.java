package edu.hbuas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hbuas.entity.Topic;
import edu.hbuas.service.TopicService;
import edu.hbuas.service.impl.TopicServiceImpl;

/**
 * Servlet implementation class DeleteTopicServlet
 */
@WebServlet("/admin/DeleteTopic")
public class DeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//获取tname
				int tid=Integer.parseInt(request.getParameter("tid"));
				
				//处理信息
				TopicService ts=new TopicServiceImpl();
				boolean flag=ts.deletebytopic(tid)>0;
				PrintWriter out=response.getWriter();
				if(flag) {
					 out.print("<script>alert('删除成功！')</script>");
				}else {
					 out.print("<script>alert('该主题已被使用，无法删除，删除失败！')</script>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
