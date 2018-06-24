package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID =request.getParameter("id");
		
		int id=Integer.parseInt(ID);
		
		LibraryDAO library=new LibraryDAO();
		boolean flag=library.deleteBook(id);
		if(flag) {
			request.getRequestDispatcher("Administrator").forward(request, response);
		}
		else {
			System.out.println("É¾³ýÊ§°Ü");
		}
	}

}
