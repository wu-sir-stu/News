package edu.hbuas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hbuas.entity.Users;
import edu.hbuas.service.UsersService;
import edu.hbuas.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UserExistServlet
 */
@WebServlet("/userexist")
public class UserExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String uname=request.getParameter("username");
		System.out.println("uname:"+uname);
		UsersService us=new UsersServiceImpl();
		
		PrintWriter out=response.getWriter();
		boolean flag=us.ExistUser(uname);
		
		if(flag) {
			out.print("用户存在");
		}else {
			out.print("用户不存在");
		}
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
