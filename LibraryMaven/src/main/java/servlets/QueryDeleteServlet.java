package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;

/**
 * Servlet implementation class QueryDeleteServlet
 */
public class QueryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("str");
		String []Query=str.split(",");
		LibraryDAO library=new LibraryDAO();
		for(String a:Query) {
			int id=Integer.parseInt(a);
			library.deleteBook(id);
		}
		request.getRequestDispatcher("Administrator").forward(request, response);
	}

}
