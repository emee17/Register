package DatabaseConnectivity;

import java.sql.*;

public class JDBC2 
{
   public static void main(String[] args) {
	  
	   int id = 3, salary = 15000; String name = "Vision";
	   int id2 = 5, salary2 = 2000; String name2 = "Thor";
	 try {
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("driver loaded");
		   
		   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yjava","root","namaz@sql");
		   
		   /* java.sql.Statement stmt=con.createStatement();
		   System.out.println("Connection established");
		   
		   int i= stmt.executeUpdate("insert into emp7  values("+id+",'"+name+"','" +salary+ "')");*/
		   
		   PreparedStatement ps = con.prepareStatement("insert into  emp7 values (?,?,?) ");
		   ps.setString(1, id2+"");
		   ps.setString(2, name2);
		   ps.setString(3, salary2+"");
		   
		   int update = ps.executeUpdate();
		   System.out.println(update+" affected");
		   ResultSet rs = ps.executeQuery("Select * from emp7");
		   
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		   }
		   con.close();
	 	}
	 catch(Exception e)
	   {
		   System.out.println("Exception : "+e.getMessage());
	   }
	  
}
}
