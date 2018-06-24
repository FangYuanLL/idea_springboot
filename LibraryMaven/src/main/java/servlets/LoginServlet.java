package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;

/**
 * Servlet implementation class AddUserServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	
    	UsersDAO user=new UsersDAO();
    	boolean flag=user.findUser(username, password);
    	System.out.println(flag);
    	if(flag) {
    		request.getRequestDispatcher("Administrator").forward(request, response);
    	}
    	else {
    		System.out.println("µÇÂ¼Ê§°Ü");
    	}
	
    	
    }

}
