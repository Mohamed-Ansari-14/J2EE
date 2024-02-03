package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dao.StudentDao;
import student.dto.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student dbStudent = studentDao.findStudent(id);
		
		//getting HttpSession
		HttpSession httpSession = req.getSession();
		String name = (String)httpSession.getAttribute("studentWhoLoggedIn");
		
		if(name != null)
		{
			//he is valid student
			req.setAttribute("student", dbStudent);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
			requestDispatcher.forward(req, resp);
		}
		else
		{
			//when name = null
			req.setAttribute("message", "Not a Valid User !!! Login to Continue");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
