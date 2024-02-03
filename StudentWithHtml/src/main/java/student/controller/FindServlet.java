package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class FindServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.findStudentById(id);
		
		if(student != null)
		{
			//Student is Present
			PrintWriter printWriter = resp.getWriter();
			printWriter.print(student);
		}
		else
		{
			//Student ID is not present
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("Sorry ID is Not Present !!!");
		}
	}
}
