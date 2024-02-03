package executeMethodConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteQueryMethod 
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
		ResultSet value = statement.executeQuery("insert into user values(4,'Mohamed','Chennai')");
		System.out.println(value);
		/*
		 * Return Type --> ResultSet-->Interface
		 * executeQuery()Method is only use for Select Query,
		 * we can't use executeQuery() method for DML Statements it will Throw the Run-Time_Excepion.
		 */

		//5.Close the Connection.
		connection.close();

		System.out.println("Data Inserted Successfully !!!");
	}
}
