package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;

public class CustomerDeleteServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		if(id != 1) {
		System.out.println("Delete Id: " + id);
		new CustomerDAO().delete(id);
		System.out.println("A customer has been deleted");
		}
		response.sendRedirect("/customerList");
	}
}
