package mavenJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EstablishTheConnection 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc?user=root&password=root");
		Statement statement = connection.createStatement();
		statement.execute("insert into user values(3,'Deepan','Chennai')");
		connection.close();
		System.out.println("Data Inserted Successfully");
	}
}
