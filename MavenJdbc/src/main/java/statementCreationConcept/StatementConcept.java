package statementCreationConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementConcept 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		Statement statement = connection.createStatement();
		statement.execute("insert into user values(4,'Deepan','Chennai')");
		connection.close();

		System.out.println("Data Inserted Successfully !!!");
	}
}
