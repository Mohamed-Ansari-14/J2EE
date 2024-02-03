package statementCreationConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementSelectUser 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID you want to Retrieve: ");
		int id = scanner.nextInt();
		
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println("Id --> "+resultSet.getInt(1));
			System.out.println("Name --> "+resultSet.getString(2));
			System.out.println("Address --> "+resultSet.getString(3));
		}
		
		connection.close();
		scanner.close();
		System.out.println("Data Retrieved Successfully !!!");
	}
}
