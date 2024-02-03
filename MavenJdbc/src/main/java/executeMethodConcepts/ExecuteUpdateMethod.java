package executeMethodConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteUpdateMethod
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
		int value = statement.executeUpdate("insert into user values(4,'Mohamed','Chennai')");
		System.out.println(value);
		/*
		 *Return Type --> int
		 * executeUpdate()Method is print the number of rows Affected,
		 * executeUpdate()Method is Not Applicable for Select Query,
		 * we can use only on DML statements.
		 */

		//5.Close the Connection.
		connection.close();

		System.out.println("Data Inserted Successfully !!!");
	}
}
