package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String info = request.getParameter("info");
		String ipaddr = request.getRemoteAddr();

		System.out.println("LoginServletInfo:" + info);
		System.out.println(ipaddr);
	
		if(info.isEmpty()&&name.equals("root")&&password.equals("tvws")){ //Direct to productList
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("productList");
			
		}
		
		else if(!info.isEmpty()&&name.equals("root")&&password.equals("tvws")) { //To productScan
			request.getSession().setAttribute("userName", name);
			request.setAttribute("info",info);
			request.getRequestDispatcher("productScan").forward(request, response);		
		}else {
			System.out.println("Password or Username wrong");
			response.sendRedirect("login.jsp");
		}
		
	}
	
}
