package mavenJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class LoadAndRegisterDriver 
{
	public static void main(String[] args) throws Exception 
	{
		//we can Load and Register the Driver Explicitly
		
		//1.Load and Register the Driver.
		//a.Load the Driver.
		Driver driver = new Driver();
		//b.Register the Driver.
		DriverManager.registerDriver(driver);
		
		//2.Establish the Connection.
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		
		//3.Create Statement.
		Statement statement = connection.createStatement();
		
		//4.Execute the Query.
		statement.execute("Delete from user where id = 3");
		
		//5.Close the Connection.
		connection.close();
		
		System.out.println("Data Deleted Successfully !!!");
	}
}
