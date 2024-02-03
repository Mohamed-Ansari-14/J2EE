package statementCreationConcept;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStatementInsert2 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		
		CallableStatement callableStatement = connection.prepareCall("call insertUser(?,?,?)");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID: ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name: ");
		String name = scanner.next();
		System.out.println("Enter the Address: ");
		String address = scanner.next();
		
		callableStatement.setInt(1, id);
		callableStatement.setString(2, name);
		callableStatement.setString(3, address);
		callableStatement.execute();
		
		connection.close();
		scanner.close();
		System.out.println("Data Inserted Successfully using CallabaleStatement !!!");
	}
}
