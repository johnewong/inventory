package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Product;
import inventory.ProductDAO;

public class ProductAddServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException	{
		
		request.setCharacterEncoding("UTF-8");
		
		Product product = new Product();
		product.setProductName(request.getParameter("productName"));
		product.setType(request.getParameter("type"));
		product.setCreateDate(new Date());
		product.setMACAddr(request.getParameter("macAddr"));
		product.setStatus(request.getParameter("status"));
		//product.setCid(Integer.parseInt((request.getParameter("cid"))));
		product.setPassword(request.getParameter("password"));
		product.setComment(request.getParameter("comment"));

		new ProductDAO().add(product);
		response.sendRedirect("/productList");
	}
	
}
