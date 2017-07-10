package cn.xzj.amr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/pages/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession();
		if (session.getAttribute("empLogin") != null) {
			arg2.doFilter(arg0, arg1);
		} else {
			request.setAttribute("msg", "您还未登录，请先登录！");
			request.setAttribute("url", "/login.jsp");
			request.getRequestDispatcher("/forward.jsp").forward(arg0, arg1); 
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
