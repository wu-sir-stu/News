package edu.hbuas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hbuas.service.NewsService;
import edu.hbuas.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class DeleteNewsByNidServlet
 */
@WebServlet("/admin/DeleteNewsByNid")
public class DeleteNewsByNidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsByNidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码格式防止乱码
		// 获取
		request.setCharacterEncoding("utf-8");
		// 发送
		response.setContentType("text/html;charset=utf-8");
		//获取信息
		int nid=Integer.parseInt(request.getParameter("nid"));
		NewsService ns=new NewsServiceImpl();
		boolean flag=ns.deletenewsbynid(nid);
		PrintWriter out=response.getWriter();
		if(flag) {
			 out.print("<script>alert('删除成功！');location.href='GetAllNews'</script>");
		}else {
			 out.print("<script>alert('删除失败！');location.href='GetAllNews'</script>");
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
