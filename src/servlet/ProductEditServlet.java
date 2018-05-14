package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.ProductDAO;
import inventory.Product;

public class ProductEditServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("productName");
		String type = request.getParameter("type");
		String MACaddr = request.getParameter("MACaddr");
		String status = request.getParameter("status");
		String soldDate = request.getParameter("soldDate");
		int cid = Integer.parseInt(request.getParameter("cid"));
		String password = request.getParameter("password");
		String comment = request.getParameter("comment");
		System.out.println(id+productName);
		
		Product product = new Product();
		product.setId(id);
		product.setProductName(productName);
		product.setType(type);
		product.setMACAddr(MACaddr);
		product.setStatus(status);
		//product.setSoldDate(soldDate);
		product.setCid(cid);
		product.setPassword(password);
		product.setComment(comment);
		if(status.equals("sold")) 
			product.setSoldDate(soldDate);
		 else
			product.setSoldDate("");
		
		
		
		new ProductDAO().update(product);		
		response.sendRedirect("productList");
	}
}
