package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class SignUpServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		Student student = new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		
		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(student);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
		requestDispatcher.forward(req, res);
	}
	
}














