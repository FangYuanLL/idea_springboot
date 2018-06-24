package websocketTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class SocketServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<User> list=new ArrayList<User>();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(); 
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("abc")&&password.equals("123")) {
			User user=new User("abc","123");
			list.add(user);
			request.setAttribute("list", list);
			session.setAttribute("username", "abc");
			session.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(username.equals("qwe")&&password.equals("234")) {
			User user=new User("qwe","234");
			list.add(user);
			request.setAttribute("list", list);
			session.setAttribute("username", "qwe");
			session.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(username.equals("ert")&&password.equals("345")) {
			User user=new User("ert","345");
			list.add(user);
			request.setAttribute("list", list);
			session.setAttribute("username", "ert");
			session.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("Login.jsp");
		}
		
	}

}
