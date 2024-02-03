package statementCreationConcept;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStatementDelete2 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		CallableStatement callableStatement = connection.prepareCall("call deleteUser(?) ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Id you want to Delete ");
		int id = scanner.nextInt();
		
		callableStatement.setInt(1, id);
		callableStatement.execute();
		
		scanner.close();
		connection.close();
		System.out.println("Data Deleted Successfully using CallableStatement !!!");
	}
}
