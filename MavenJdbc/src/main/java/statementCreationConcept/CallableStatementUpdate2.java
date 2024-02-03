package statementCreationConcept;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStatementUpdate2 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		CallableStatement callableStatement = connection.prepareCall("call updateUser(?,?,?)");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Id You Want to Update: ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name: ");
		String name = scanner.next();
		System.out.println("Enter the Address: ");
		String address = scanner.next();
		
		callableStatement.setString(1, name);
		callableStatement.setString(2, address);
		callableStatement.setInt(3, id);
		callableStatement.execute();
		
		scanner.close();
		connection.close();
		System.out.println("Data Updated Successfully using CallableStatement");
	}
}
