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
import java.util.List;

@WebServlet("/admin/GetAllUsers")
public class GetAllUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有用户信息
        UsersService usersService=new UsersServiceImpl();
        List<Users> allusers=usersService.getallusers();
        HttpSession session=request.getSession();
        session.setAttribute("allusers",allusers);
        //System.out.println(allusers.get(1).toString());
        request.setAttribute("allusers", allusers);
        request.getRequestDispatcher("/admin/show_user.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
