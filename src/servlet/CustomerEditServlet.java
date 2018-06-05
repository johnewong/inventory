package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import dao.CustomerDAO;

public class CustomerEditServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		Customer c = new Customer();
		int id = Integer.parseInt(request.getParameter("id"));
		String companyName = request.getParameter("companyName");
		String contactName = request.getParameter("contactName");
		String contactNumber = request.getParameter("contactNumber");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		int total = Integer.parseInt(request.getParameter("total"));
		
		c.setId(id);
		c.setCompanyName(companyName);
		c.setContactName(contactName);
		c.setContactNumber(contactNumber);
		c.setEmail(email);
		c.setStatus(status);
		c.setTotal(total);
		
		new CustomerDAO().update(c);
		response.sendRedirect("/customerList");
	}
	
}
