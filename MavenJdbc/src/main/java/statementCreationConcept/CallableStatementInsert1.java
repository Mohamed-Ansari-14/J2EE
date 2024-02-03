package statementCreationConcept;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementInsert1
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavenjdbc","root","root");
		
		CallableStatement callableStatement = connection.prepareCall("call insertUser(4,'Bhuva','Chennai')");
		callableStatement.execute();
		connection.close();
		System.out.println("Data Inserted Successfully using CallabaleStatement !!!");
	}
}
