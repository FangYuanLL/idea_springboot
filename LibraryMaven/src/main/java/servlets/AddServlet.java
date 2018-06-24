package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Books;
import dao.LibraryDAO;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	String name=request.getParameter("name");
    	int price=Integer.parseInt(request.getParameter("price"));
    	String publishTime=request.getParameter("publishTime");
    	String author=request.getParameter("author");
    	System.out.println(id);
    	LibraryDAO library=new LibraryDAO();
    	Books book=new Books(id,name,price,publishTime,author);
    	boolean flag=library.addBook(book);
    	if(flag) {
    		request.getRequestDispatcher("Administrator").forward(request, response);
    	}
    	else{
    		System.out.println("ÃÌº” ß∞‹");
    	}
    	
    }

}
