package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//1.Load and Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//2.Establish the Connection.
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");

		//3.Create Statement.
		Statement statement = connection.createStatement();

		//4.Execute the Query.
		statement.execute("insert into user values(1,'Ansari','Chennai',)");
		
		//5.Close the Connection.
		connection.close();
		System.out.println("Data Inserted Successfully !!!");
	}
}
