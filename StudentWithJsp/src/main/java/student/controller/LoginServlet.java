package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dao.StudentDao;
import student.dto.Student;

@WebServlet("/login") //-->Configuring the url of Servlet
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentDao = new StudentDao();
		List<Student> list = studentDao.getAllStudents();
		
		boolean value = false;
		String studentPasswordFromDB = null;
		String studentName = null;
		
		for(Student student:list)
		{
			if(email.equals(student.getEmail()))
			{
				value=true;
				studentPasswordFromDB = student.getPassword();
				studentName = student.getName();
				break;
			}
		}
		
		//Create a cookie
		Cookie cookie = new Cookie("studentWhoLoggedIn", studentName);
		resp.addCookie(cookie);
		
		//Create a HttpSession
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("studentWhoLoggedIn", studentName);
		
		if(value)
		{
			//Email is Present
			if(password.equals(studentPasswordFromDB))
			{
				//Login Success
				req.setAttribute("list", list);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
				requestDispatcher.forward(req, resp);
			}
			else
			{
				//Password is Invalid
				req.setAttribute("message", "Invalid Password !!!");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.include(req, resp);
			}
			
		}
		else
		{
			//Email is Not Present
			req.setAttribute("message", "Invalid Email !!!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}


















