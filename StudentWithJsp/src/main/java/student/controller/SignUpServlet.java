package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class SignUpServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext servletContext = getServletContext();
		double fees = Double.parseDouble(servletContext.getInitParameter("fees"));
		
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setAddress(address);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		student.setFees(fees);
		
		StudentDao studentDao = new StudentDao();
		List<Student>students = studentDao.getAllStudents();
		boolean value = false;
		for(Student dbStudent:students)
		{
			if(email.equals(dbStudent.getEmail()))
			{
				value = true;
				break;
			}		
		}
		
		if(value)
		{
			//Value = true when that given email is already present in the database.
			req.setAttribute("message", "Sorry Email is already Exist Please give different Email !!!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
			requestDispatcher.include(req, resp);
		}
		else
		{
			//Value = false when that given email is Not present in the database.
			studentDao.saveStudent(student);
			req.setAttribute("message", "Signed Up Successfully Please Login");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}










