package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.Item;
import inventory.ItemDAO;

public class ItemGetServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		Item i = new ItemDAO().get(id);
		request.setAttribute("item", i);
		request.getRequestDispatcher("editItem.jsp").forward(request, response);
	}
}
