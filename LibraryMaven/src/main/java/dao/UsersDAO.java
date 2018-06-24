package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDAO {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/testdb";
	public static final String DBUSER="root";
	public static final String DBPASS="lfy1224";
	private Connection conn=null;
	private PreparedStatement pStat=null;
	private ResultSet rs=null;
	
	public void close(){
        try{
			if( rs!=null ) rs.close();
			if( pStat!=null ) pStat.close();
			if( conn!=null ) conn.close();
        }catch(Exception e){	e.printStackTrace();        }
     }  //end close
	
	 public Connection getConnectionn1(){
	        try{
		Class.forName(DRIVER).newInstance(); 
	    	return DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	        }catch(Exception e){
		return null;
	        }
	    }
	 //是否存在存在返回true
	 public boolean isUsernameExists(String username) {
	        conn=getConnectionn1();
	        System.out.println("username:"+username);
		    try {
		    	String sql="select * from users where username='"+username+"'";
				pStat =conn.prepareStatement(sql);  
				rs=pStat.executeQuery();
				if( rs.next() )    return true;
				else  {  System.out.println("rs不为空"); return false;}
		        }catch (Exception e) {   System.out.println("异常"); return false;      }
		        finally{    close();      }			
		     } 	

	 public boolean addUser(String username,String password) {   
        conn=getConnectionn1();
        System.out.println("username+password:"+username+","+password);
        try {
		pStat=conn.prepareStatement("insert into users values(null,?,?)");  	
	    pStat.setString(1, username);
		pStat.setString(2, AddMD5.getMD5(password));
		int cnt=pStat.executeUpdate();
		if(cnt>0)	     return true;
		else     return false;
		}
		catch (Exception e) {     return false;	}
		finally{close();}			
	    }
	 public boolean findUser(String username, String password){
	        conn=getConnectionn1();
	        try {
		pStat =conn.prepareStatement("select * from users where username=? and password=?");  
		pStat.setString(1, username);
		pStat.setString(2,AddMD5.getMD5(password));
		rs=pStat.executeQuery();
		if( rs.next() )    return true;
		else     return false;
		}
		catch (Exception e) {    return false;	}
		finally{
		    close();
		}			
	     }  //end findUser

}
