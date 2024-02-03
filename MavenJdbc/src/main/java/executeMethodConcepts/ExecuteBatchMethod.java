package executeMethodConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ExecuteBatchMethod 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?)");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter How Many Enteries You want to Store:");
		int numberOfEntries = scanner.nextInt();
		
		int i=0;
		while(i<numberOfEntries)
		{
			System.out.println("Enter Your ID: ");
			int id = scanner.nextInt();
			System.out.println("Enter Your Name: ");
			String name = scanner.next();
			System.out.println("Enter Your Address: ");
			String address = scanner.next();
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(3, address);
			preparedStatement.setString(2, name);
			
			preparedStatement.addBatch();
			i++;
		}
		preparedStatement.executeBatch();
		connection.close();
		scanner.close();
	}
}





