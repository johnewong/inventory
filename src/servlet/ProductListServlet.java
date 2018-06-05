package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.CustomerDAO;
import dao.ProductDAO;

public class ProductListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
		if(request.getParameter("search")!=null&&request.getParameter("key")!=null) {
			
			String search = request.getParameter("search");
			String key =request.getParameter("key");
			int id = 0;
			
			if(search.equals("companyName")) {
				id = new CustomerDAO().getId(key);
			}
	
			switch(search){
	        case "companyName":
	        	List<Product>productsByCompany = new ProductDAO().listProductByCompanyId(id);
	        	request.setAttribute("products", productsByCompany);
	        	break;
	            
	        case "productName":
	        	List<Product>productsByProduct = new ProductDAO().listProductByProductName(key);
	        	request.setAttribute("products", productsByProduct);
	        	break;
	            
	        case "status":
	        	List<Product>productsByStatus = new ProductDAO().listProductByStatus(key);
	        	request.setAttribute("products", productsByStatus);
	        	break;
	       
	        default:
	        	List<Product>products = new ProductDAO().list();
	        	request.setAttribute("products", products);
			}
		}
		else {
		List<Product>products = new ProductDAO().list();
        request.setAttribute("products", products);
		}
		
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);
    }
}
