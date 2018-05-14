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
		String info = request.getParameter("macAddr");
		
	
		if(name.equals("root")&&password.equals("tvws")){
			request.getSession().setAttribute("userName", name);
			//request.setAttribute("macAddr",info);
			//System.out.println(info);
			response.sendRedirect("productScan");
			
		}
		
		else if(!info.isEmpty()&&name.equals("root")&&password.equals("tvws")) {
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("productList");
		}else {
			System.out.println("Password or Username wrong");
			response.sendRedirect("login.html");
		}
		
	}
	
}
