package websocketTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class CheckSession
 */
public class CheckSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings({ "unchecked" })
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		HttpSession session=((HttpServletRequest) request).getSession();
		List<User> list=new ArrayList<User>();
		list=(List<User>) session.getAttribute("list");
		String username =(String) session.getAttribute("username");
		Iterator<User> it=list.iterator();
		while(it.hasNext()) {
			User u=it.next();
			if(u.getUsername().equals(username)) {
				it.remove();
			}
		}
		request.setAttribute("list", list);
		session.setAttribute("list", list);
		for(User x:list) {
			System.out.println(x.getUsername());
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
    

}
