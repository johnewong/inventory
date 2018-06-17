package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import inventory.PasswordGenerator;

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
		int cid = 0;
		cid = Integer.parseInt(request.getParameter("cid"));
		String password = null;
		if(status.equals("sold")) {//password generator
			PasswordGenerator pg = new PasswordGenerator();
			password = pg.PasswordGenerator(MACaddr);
		}	else {
			password = request.getParameter("password");
		}
		String comment = request.getParameter("comment");
		int price = Integer.parseInt(request.getParameter("price"));
		Product product = new Product();
		product.setId(id);
		product.setProductName(productName);
		product.setType(type);
		product.setMACAddr(MACaddr);
		product.setStatus(status);
		product.setCid(cid);
		product.setPassword(password);
		product.setComment(comment);
		product.setPrice(price);
		if(status.equals("other")||status.equals("sold")) 
			product.setSoldDate(soldDate);
		 else
			product.setSoldDate("");
		new ProductDAO().update(product);		
		response.sendRedirect("productList");
	}
}
