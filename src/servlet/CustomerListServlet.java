package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Customer;
import inventory.CustomerDAO;
import inventory.Product;
import inventory.ProductDAO;

public class CustomerListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
            response.sendRedirect("login.jsp");
            return;
        }
		
        if(request.getParameter("search")!=null&&request.getParameter("key")!=null) {
        	String search = request.getParameter("search");
			String key =request.getParameter("key");
			
			switch(search){
	        case "companyName":
	        	List<Customer>customersByCompany = new CustomerDAO().listCustomerByCompanyName(key);
	        	request.setAttribute("customers", customersByCompany);
	        	break;
	            
	        case "contactName":
	        	List<Customer>customersByContact = new CustomerDAO().listCustomerByContact(key);
	        	request.setAttribute("customers", customersByContact);
	        	break;
	            
	        case "status":
	        	List<Customer>customersByStatus = new CustomerDAO().listCustomerByStatus(key);
	        	request.setAttribute("customers", customersByStatus);
	        	break;
	       
	        default:
	        	List<Customer>products = new CustomerDAO().list();
	        	request.setAttribute("customers", products);
			}		
        } else {
        	List<Customer> customers = new CustomerDAO().list();
    		request.setAttribute("customers", customers);
        }
 
		
		request.setAttribute("userName", userName);
		request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
	}
	
}
