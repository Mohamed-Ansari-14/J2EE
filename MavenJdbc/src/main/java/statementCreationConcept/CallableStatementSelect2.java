package statementCreationConcept;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class CallableStatementSelect2 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		CallableStatement callableStatement = connection.prepareCall("call selectUser(?) ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID You Want to Select: ");
		int id = scanner.nextInt();
		callableStatement.setInt(1, id);
		ResultSet resultSet = callableStatement.executeQuery();
		while(resultSet.next())
		{
			System.out.println("ID = "+resultSet.getInt("id"));
			System.out.println("Name = "+resultSet.getString("name"));
			System.out.println("Address = "+resultSet.getString(3));
		}
		
		scanner.close();
		connection.close();
		System.out.println("Data Retrieved Successfully using CallabaleStatement !!!");
	}
}
