package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAllStudents();
		boolean value = false;
		String studentPasswordFromTheDatabase = null;
		
		for(Student student:students)
		{
			if(email.equals(student.getEmail()))
			{
				value = true;
				studentPasswordFromTheDatabase = student.getPassword();
				break;
			}
		}
		
		if(value)
		{
			//Student Email  is Present 
			if(password.equals(studentPasswordFromTheDatabase))
			{
				//its Perfect Password
//				RequestDispatcher requestDispatcher = req.getRequestDispatcher("FindStudent.html");
//				requestDispatcher.forward(req, resp);
				resp.sendRedirect("https://www.javatpoint.com/java-tutorial");
			}
			else
			{
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
				requestDispatcher.include(req, resp);
			}
		}
		else
		{
			//Student Email is not Present
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		}
	}
}














