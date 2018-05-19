package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Product;
import inventory.ProductDAO;
import inventory.Customer;
import inventory.CustomerDAO;

public class ProductScanServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String macAddr = request.getParameter("macAddr");
		String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
        	request.setAttribute("info", macAddr);
        	request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        macAddr = request.getParameter("info");
		Product product = new ProductDAO().scan(macAddr);
		List<Customer> customers = new CustomerDAO().list();
		
		request.setAttribute("product", product);
		request.setAttribute("customers", customers);
		request.setAttribute("userName", userName);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
		
	}
}
