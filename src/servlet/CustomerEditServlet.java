package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.CustomerDAO;
import inventory.Customer;

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
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = request.getParameter("status");
		
		c.setId(id);
		c.setCompanyName(companyName);
		c.setContactName(contactName);
		c.setContactNumber(contactNumber);
		c.setEmail(email);
		c.setQuantity(quantity);
		c.setStatus(status);
		
		new CustomerDAO().update(c);
		response.sendRedirect("customerList");
	}
	
}
