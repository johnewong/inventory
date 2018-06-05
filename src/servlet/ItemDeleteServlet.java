package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;

public class ItemDeleteServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Delete id: "+id);
		new ItemDAO().delete(id);
		System.out.println("A item has been deleted");
		response.sendRedirect("/itemList");
	}
}
