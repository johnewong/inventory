package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		
		String uri = request.getRequestURI();
		 if(uri.endsWith(".css") || uri.endsWith(".js")) {
	            chain.doFilter(request, response);
	            return;        
	    }
		 
		if(uri.endsWith("login.jsp")||uri.endsWith("login")) {
			chain.doFilter(request, response);
			return;
		}
		
		String name = (String) request.getSession().getAttribute("userName");
		if(null == name) {
			String info = null;
			
			if(request.getParameter("macAddr")!=null) {//info = macAddr
				info = request.getParameter("macAddr");
				request.setAttribute("info", info);
				System.out.println("info: "+info);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}		
			response.sendRedirect("login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
