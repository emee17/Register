package DatabaseConnectivity;

import java.sql.*;

public class JDBCDemo 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yjava","root","namaz@sql");
		
		Statement st = con.createStatement();
		
		// To Execute Single record
		/*ResultSet rs = st.executeQuery("Select name from emp7 where id=33 ");
		
		rs.next();
		
		String name = rs.getString("name");
		
		System.out.println(name);*/
		
		//To Execute Whole table
		/*ResultSet rs = st.executeQuery("Select * from dept");
		
		while(rs.next())
		{
			String data = rs.getString(1)+" : "+rs.getString(2);
			System.out.println(data);
		}*/
		
		st.close();
		con.close();
		
		
	}
}
