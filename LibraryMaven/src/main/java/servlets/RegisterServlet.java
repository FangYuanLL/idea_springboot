package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	UsersDAO user=new UsersDAO();
    	boolean flag=user.isUsernameExists(username);
    	System.out.println(flag);
    	if(flag) {
    		System.out.println("×¢²áÊ§°Ü");
    	}
    	else {
    		boolean bool=user.addUser(username,password);
    		if(bool) {
    			System.out.println("Ìí¼Ó³É¹¦£¡");
    			request.getRequestDispatcher("Administrator").forward(request, response);
    		}
    		else {
    			System.out.println("Ìí¼ÓÊ§°Ü£¡");
    		}
    		
    	}
    	
    }
}
