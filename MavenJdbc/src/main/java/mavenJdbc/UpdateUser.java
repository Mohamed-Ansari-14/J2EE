package mavenJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateUser 
{
	public static void main(String[] args) throws Exception
	{
		//1.Load and Register the Driver.
		Class.forName("com.mysql.cj.jdbc.Driver");

		//2.Establish the Connection.
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");

		//3.Create Statement.
		Statement statement = connection.createStatement();

		//4.Execute the Query.
		statement.execute("update user set address='Tenkasi' where id = 1");

		//5.Close the Connection.
		connection.close();

		System.out.println("Data Updated Successfully !!!");
	}
}
