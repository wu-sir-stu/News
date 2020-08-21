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
 * Servlet implementation class GetUsernameServlet
 */
@WebServlet("/GetUsername")
public class GetUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUsernameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String keyname = request.getParameter("keyname");
		PrintWriter out = response.getWriter();
		if (!keyname.trim().equals("")) {
			UsersService us = new UsersServiceImpl();
			String name = us.getuser(keyname);
			if (name.equals("")) {
				out.print("");
			} else {
				
				out.print(name);
			}
		}

		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
