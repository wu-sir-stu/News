package edu.hbuas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/admin/AddNews")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式防止乱码
		//获取
		request.setCharacterEncoding("utf-8");
		//发送
		response.setContentType("text/html;charset=utf-8");
		//获取信息
		String ntname=request.getParameter("ntname");
		String ntitle=request.getParameter("ntitle");
		String nauthor=request.getParameter("nauthor");
		String nsummary=request.getParameter("nsummary");
		String ncontent=request.getParameter("ncontent");
		//根据tname获取tid
		TopicService ts=new TopicServiceImpl();
		Topic topic=ts.getbytname(ntname);
		int ntid=topic.getTid();
		//封装信息
		News news=new News();
		news.setNtid(ntid);
		news.setNtitle(ntitle);
		news.setNauthor(nauthor);
		news.setNcreateDate(new Date());
		news.setNcontent(ncontent);
		news.setNsummary(nsummary);
		//System.out.println(news.toString());
		//数据操作
		NewsService ns=new NewsServiceImpl();
		boolean flag=ns.addnews(news);
		PrintWriter out=response.getWriter();
		if(flag) {
			 out.print("<script>alert('添加成功！');location.href='GetAllNews'</script>");
		}else {
			 out.print("<script>alert('添加失败！');location.href='add_news.jsp'</script>");
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
