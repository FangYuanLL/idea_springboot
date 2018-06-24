package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Books;

public class LibraryDAO {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/testdb";
	public static final String DBUSER="root";
	public static final String DBPASS="lfy1224";
	private Connection conn=null;
	private PreparedStatement pStat=null;
	private ResultSet rs=null;
	//底层数据连接函数
	public Connection getConnection() {
		
			try {
				Class.forName(DRIVER).newInstance();
				return DriverManager.getConnection(DBURL, DBUSER,DBPASS);
			} catch (Exception e) {
				
				return null ;
			} 

	}
	
	public void close() {
			try {
				if(rs!=null) rs.close();
				if(pStat!=null) pStat.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			}
	}
	//查询图书是否存在
	public boolean isBooknameExists(String name) {
		conn=getConnection();
		
		try {
			pStat=conn.prepareStatement("select *from adbt where name=?");
			pStat.setString(1, name);
			rs=pStat.executeQuery();
			if(rs.next()) return true;
			else return false;
		} catch (Exception e) {
			
			return false;
		}
		finally {close();}	
	}
	//查询所有的图书数据
	public ResultSet findBooks() {
		conn=getConnection();
		try {
			pStat=conn.prepareStatement("select * from adbt ");
			rs=pStat.executeQuery();
			//System.out.println("1111");
			return rs;
		} catch (Exception e) {
			return null;
		}		
	}
	//依据名字查询
	public ResultSet findBooks1(String name) {
		conn=getConnection();
		try {
			pStat=conn.prepareStatement("select * from adbt where name=? ");
			pStat.setString(1, name);	
			rs=pStat.executeQuery();
			return rs;
		} catch (Exception e) {
			return null;
		}
			
	}
	//依据价格区间查询
	public ResultSet findBooks2(int MINprice,int MAXprice) {
		conn=getConnection();
		try {
			pStat=conn.prepareStatement("select * from adbt where price between ? and ? ");
			pStat.setLong(1, MINprice);	
			pStat.setLong(2, MAXprice);
			rs=pStat.executeQuery();
			return rs;
		} catch (Exception e) {
			return null;
		}
				
	}
	//依据出版时间查询
	public ResultSet findBooks3(String publishTime) {
		conn=getConnection();
		try {
			pStat=conn.prepareStatement("select * from adbt where publishTime=? ");
			pStat.setString(1, publishTime);	
			rs=pStat.executeQuery();
			return rs;
		} catch (Exception e) {
			return null;
		}		
	}
	//依据主键id查询
	public ResultSet findBooks4(int id) {
		conn=getConnection();
		try {
			pStat=conn.prepareStatement("select * from adbt where id=? ");
			pStat.setInt(1, id);	
			rs=pStat.executeQuery();
			return rs;
		} catch (Exception e) {
			return null;
		}
		
	}
	//添加图书数据
	public boolean addBook(Books book) {
		conn=getConnection();
		
		try {
			//System.out.println(book.getAuthor());
			String sql="insert into adbt values("+book.getId()+",'"+book.getName()+"',"+book.getPrice()+",'"+book.getPublishTime()+"','"+book.getAuthor()+"')";
			//System.out.println(sql);
			pStat=conn.prepareStatement(sql);
			int cnt=pStat.executeUpdate();
			if(cnt>0) return true;
			else return false;
		
		} catch (Exception e) {
			
			return false;
		}finally {close();}	
	}
	//更新图书数据
	public boolean Update(int id,String name,int price,String publishTime,String author) {
		conn=getConnection();
		
		try {
			
				pStat=conn.prepareStatement("update adbt set name=?,price=?,publishTime=?,author=? where id=?");
				pStat.setString(1, name);		
				pStat.setInt(2,price);
				pStat.setString(3, publishTime);
				pStat.setString(4, author);
				pStat.setInt(5, id);
				int cnt=pStat.executeUpdate();
			
				if(cnt>0) return true;
				else return false;
			} catch (Exception e) {
				return false;
			}
			finally {close();}		
	}
	//删除图书数据
	public boolean deleteBook(int id) {
		conn=getConnection();
		
		try {
			pStat=conn.prepareStatement("delete from adbt where id=?");
			pStat.setInt(1, id);
			int cnt=pStat.executeUpdate();
			if(cnt>0) return true;
			else return false;
		
		} catch (Exception e) {
			
			return false;
		}finally {close();}	
	}


	public ResultSet Search(String context) {
		conn=getConnection();
		try {
			String sql="select * from adbt where name like '%"+context+"%'";
			pStat=conn.prepareStatement(sql);			
			//pStat.setString(1,text);
			rs=pStat.executeQuery();
			System.out.println("1232134213");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("模糊查询出错");
			return null;
		}
		
	}
	
	public List<Books> listAllOf(int startIndex, int offset) {
        List<Books> books = new ArrayList<Books>();
        conn=getConnection();
        try {
        	pStat=conn.prepareStatement("SELECT * FROM adbt LIMIT ?,?"); 
        	pStat.setInt(1, startIndex);
        	pStat.setInt(2, offset);
            ResultSet rs = pStat.executeQuery();
            while (rs.next()) {
            	int id=rs.getInt("id");	
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String publishTime=rs.getString("publishTime");
				String author=rs.getString("author");
                Books book = new Books(id,name,price,publishTime,author);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
	
	public int Count() {
		conn=getConnection();
		int count=0;
		try {
			pStat=conn.prepareStatement("select * from adbt ");
			rs=pStat.executeQuery();
			//System.out.println("1111");
			while(rs.next()) {
				count++;
			}
		} catch (Exception e) {
			return 0;
		}
		return count;		
	}
}

