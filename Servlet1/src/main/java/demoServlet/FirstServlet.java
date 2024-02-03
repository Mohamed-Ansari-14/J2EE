package demoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter printWriter = res.getWriter();
		//Used to print in Browser
		printWriter.print("Successfully I Created My First Servlet and Received Response in the Browser !!!");
	}
	
}
