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
 * Servlet implementation class AddTopicServlet
 */
@WebServlet("/admin/AddTopic")
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取tname
		String tname=request.getParameter("tname");
		//封装信息
		Topic newtopic=new Topic();
		newtopic.setTname(tname);
		//处理信息
		TopicService ts=new TopicServiceImpl();
		boolean flag=ts.addtopic(newtopic);
		PrintWriter out=response.getWriter();
		if(flag) {
			 out.print("<script>alert('添加成功！')</script>");
		}else {
			 out.print("<script>alert('添加失败！')</script>");
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
