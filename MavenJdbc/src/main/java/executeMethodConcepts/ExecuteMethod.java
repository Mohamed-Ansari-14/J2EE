package executeMethodConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteMethod 
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
		boolean value = statement.execute("insert into user values(3,'Mohamed','Chennai')");
		System.out.println(value);//-->False
		/*
		 *Return Type --> Boolean
		 * execute()Method print true for only select Query,
		 * it Prints False for all the DML Statements.
		 */
		
		//5.Close the Connection.
		connection.close();

		System.out.println("Data Inserted Successfully !!!");
	}
}
