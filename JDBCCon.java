package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCCon {

	public static void main(String[] args) {
		
			
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/yjava","root","namaz@sql");
			java.sql.Statement stmt=con.createStatement(); 
			
			//to update 
			/*int i= stmt.executeUpdate("update emp7 set id=2 where name='irfan'");
			System.out.println(i+" row affected");*/
			
			ResultSet rs = stmt.executeQuery("select * from emp7");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			con.close();
			
	//System.out.println(i+"inserted");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
