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
 * Servlet implementation class UpdateTopicServlet
 */
@WebServlet("/admin/UpdateTopic")
public class UpdateTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTopicServlet() {
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
				int tid=Integer.parseInt(request.getParameter("tid"));
				String tname=request.getParameter("tname");
				//封装信息
				Topic utopic=new Topic();
				utopic.setTid(tid);
				utopic.setTname(tname);
				
				//处理信息
				TopicService ts=new TopicServiceImpl();
				boolean flag=ts.updatetopic(utopic);
				PrintWriter out=response.getWriter();
				if(flag) {
					 out.print("<script>alert('修改成功！')</script>");
				}else {
					 out.print("<script>alert('修改失败！')</script>");
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
