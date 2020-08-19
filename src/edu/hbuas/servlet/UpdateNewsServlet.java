package edu.hbuas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hbuas.entity.News;
import edu.hbuas.service.NewsService;
import edu.hbuas.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class UpdateNewsServlet
 */
@WebServlet("/admin/UpdateNews")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取信息
		int nid=Integer.parseInt(request.getParameter("nid"));
		int ntid=Integer.parseInt(request.getParameter("ntid"));

		String ntitle=request.getParameter("ntitle");
		String nauthor=request.getParameter("nauthor");
		String nsummary=request.getParameter("nsummary");
		String ncontent=request.getParameter("ncontent");
		// 封装信息
		News news = new News();
		news.setNid(nid);
		news.setNtid(ntid);
		news.setNtitle(ntitle);
		news.setNauthor(nauthor);
		news.setNmodifyDate(new Date());
		news.setNcontent(ncontent);
		news.setNsummary(nsummary);

		NewsService ns=new NewsServiceImpl();
		boolean flag=ns.updatenews(news);
		PrintWriter out=response.getWriter();
		if(flag) {
			 out.print("<script>alert('修改成功！');location.href='GetAllNews'</script>");
		}else {
			 out.print("<script>alert('修改失败！');location.href='GetAllNews'</script>");
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
