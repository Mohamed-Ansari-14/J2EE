package statementCreationConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementUpdateUser
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("update user set name=?,address=? where id = ?");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID you want to Update: ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name: ");
		String name = scanner.next();
		System.out.println("Enter the Address: ");
		String address = scanner.next();
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setInt(3, id);
		preparedStatement.execute();
		
		connection.close();
		scanner.close();
		System.out.println("Data Updated Successfully !!!");
	}
}
