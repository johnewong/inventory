package listener;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		ServletContext application = e.getSession().getServletContext();
		Integer online_number = (Integer)application.getAttribute("online_number");//Integer : int
		
		if(null == online_number) {
			online_number = 0;
		}
		
		online_number++;
		application.setAttribute("online_number", online_number);
		System.out.println("A new user login");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		ServletContext application = e.getSession().getServletContext();
		Integer online_number = (Integer)application.getAttribute("online_number");
		
		if(null == online_number) {
			online_number = 0;
		}
		
		online_number--;
		application.setAttribute("online_number", online_number);
		System.out.println("A user logout");
		
	}

}
