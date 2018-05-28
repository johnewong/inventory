package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Item;
import inventory.ItemDAO;

public class ItemAddServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		Item i = new Item();
		int safetyStock = Integer.parseInt(request.getParameter("safetyStock"));
		i.setName(request.getParameter("name"));
		i.setDesc(request.getParameter("desc"));
		i.setCategory(request.getParameter("cate"));
		i.setSafetyStock(safetyStock);
		i.setStock(Integer.parseInt(request.getParameter("stock")));
		i.setPrice(Integer.parseInt(request.getParameter("price")));
		i.setCreateDate(new Date());
		
		new ItemDAO().add(i);
		System.out.println("A new item has been added");
		response.sendRedirect("/itemList");
	}
}
