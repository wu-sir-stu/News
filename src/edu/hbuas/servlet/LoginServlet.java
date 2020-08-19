package edu.hbuas.servlet;

import edu.hbuas.entity.Users;
import edu.hbuas.service.UsersService;
import edu.hbuas.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单上信息，用户名和密码
        String uname=request.getParameter("username");
        String upwd=request.getParameter("userpwd");
        System.out.println(uname+","+upwd);
        //登陆验证
        UsersService us=new UsersServiceImpl();
        Users loginuser=us.login(uname,upwd);
        //System.out.println(loginuser.toString());
        //将信息保存到session
        HttpSession session=request.getSession();
        session.setAttribute("loginuser",loginuser);
        //转发
        //request.getRequestDispatcher("/admin/mainform.jsp").forward(request,response);
        
       //重定向
        response.sendRedirect("mainform.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
