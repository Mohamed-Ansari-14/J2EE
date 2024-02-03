package mavenJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectUser 
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
		ResultSet resultSet = statement.executeQuery("select * from user");
		
		while(resultSet.next())
		{
			System.out.print(resultSet.getInt(1)+"  ");
			System.out.print(resultSet.getString(2)+"  ");
			System.out.print(resultSet.getString(3)+"  ");
			System.out.println();
		}

		//5.Close the Connection.
		connection.close();

		System.out.println("Data Retrieved Successfully !!!");
	}
}















