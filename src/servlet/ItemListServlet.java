package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.ItemDAO;
import inventory.Item;


public class ItemListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Item> list = new ItemDAO().list();
		request.setAttribute("items", list);
		request.getRequestDispatcher("listItem.jsp").forward(request, response);
	}
	
}
