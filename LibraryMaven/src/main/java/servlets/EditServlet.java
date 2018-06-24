package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Books;
import dao.LibraryDAO;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String ID=request.getParameter("id");
    	int id=Integer.parseInt(ID);
    	
    	LibraryDAO library=new LibraryDAO();
    	ResultSet rs=library.findBooks4(id);
    	
    	List<Books> list=new ArrayList<Books>();
    	try {
			while(rs.next()) {
				int id1 =rs.getInt("id");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String publishTime=rs.getString("publishTime");
				String author=rs.getString("author");
				Books book=new Books(id1,name,price,publishTime,author);
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	library.close();
    	request.setAttribute("list", list);
    	RequestDispatcher rd=request.getRequestDispatcher("/Edit.jsp");
		rd.forward(request, response);
    }

}
