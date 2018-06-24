package servlets;

import java.io.IOException;
import java.sql.ResultSet;
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
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context=request.getParameter("context");
		System.out.println(context); 
		LibraryDAO library=new LibraryDAO();
		ResultSet rs=null;
		
		if(context.equals("name_check")) {
			String name=request.getParameter("name_input");
			rs=library.findBooks1(name);
		}
		if(context.equals("price_check")) {
			int MINprice=Integer.parseInt(request.getParameter("price1_input"));
			int MAXprice=Integer.parseInt(request.getParameter("price2_input"));
			rs=library.findBooks2(MINprice, MAXprice);
		}
		if(context.equals("date_check")) {
			String publishTime=request.getParameter("date_input");
			System.out.println(publishTime);
			rs=library.findBooks3(publishTime);
			
		}
		if(context.equals("abstract_check")) {
			String text=request.getParameter("abstract_input");
			rs=library.Search(text);
		}
		
		
		//System.out.println("context:"+text);
		//ResultSet rs=library.Search(context);
		if(rs!=null) {
			System.out.println("rs结果集不为空");
			}
			else {System.out.println("rs结果集为空");}
		
		List<Books> list=new ArrayList<Books>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				System.out.println("name:"+name);
				int price=rs.getInt("price");
				String publishTime=rs.getString("publishTime");
				String author=rs.getString("author");
				Books book=new Books(id,name,price,publishTime,author);
				list.add(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常");
			e.printStackTrace();
		}
		library.close();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}
    

}
