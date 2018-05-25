package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Item;
import inventory.ItemDAO;

public class ItemEditServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		Item i = new Item();
		//int id = Integer.parseInt(request.getParameter("id"));
		i.setId(Integer.parseInt(request.getParameter("id")));
		i.setName(request.getParameter("name"));
		i.setDesc(request.getParameter("description"));
		i.setCategory(request.getParameter("category"));
		i.setStatus(request.getParameter("status"));
		i.setSafetyStock(Integer.parseInt(request.getParameter("safetyStock")));
		i.setStock(Integer.parseInt(request.getParameter("stock")));
		i.setPrice(Integer.parseInt(request.getParameter("price")));
		System.out.println(i.getPrice());
		new ItemDAO().update(i);
		response.sendRedirect("/itemList");
	}
}
