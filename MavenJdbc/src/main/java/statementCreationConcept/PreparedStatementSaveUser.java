package statementCreationConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementSaveUser
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?)");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter ID: ");
		int id = scanner.nextInt();
		System.out.println("Please Enter Name: ");
		String name = scanner.next();
		System.out.println("Please Enter Address: ");
		String address = scanner.next();
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2,name);
		preparedStatement.setString(3, address);
		preparedStatement.execute();
		
		connection.close();
		scanner.close();
		System.out.println("Data Inserted Successfully !!!");
	}
}
