package edu.hbuas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hbuas.entity.Users;

/**
 * Servlet Filter implementation class UsersFilter
 */
@WebFilter(filterName = "UsersFilter", urlPatterns = { "*.jsp" })
public class UsersFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UsersFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("UsersFilter销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 从session中获取用户信息
		Users user = (Users) session.getAttribute("loginuser");
		// 能够从session获取到用户信息，代表用户已经成功登陆过
		if (user != null) {
			// 请求向下传递
			chain.doFilter(req, resp);
		} else {
			// 如果获取不到用户信息，代表用户没有登陆，则转向到登陆页面
			req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("UsersFilter初始化");
	}

}
