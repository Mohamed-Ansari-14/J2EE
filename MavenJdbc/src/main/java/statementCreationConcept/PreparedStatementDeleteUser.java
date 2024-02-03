package statementCreationConcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementDeleteUser 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID you want to Delete: ");
		int id = scanner.nextInt();

		preparedStatement.setInt(1, id);
		preparedStatement.execute();

		connection.close();
		scanner.close();
		System.out.println("Data Deleted Successfully !!!");
	}
}
