package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import bean.Product;
import dao.CustomerDAO;
import dao.ProductDAO;

public class ProductGetServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new ProductDAO().get(id);
		List<Customer> customers = new CustomerDAO().list();
		
		request.setAttribute("product", product);
		request.setAttribute("customers", customers);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
		
	}
}
