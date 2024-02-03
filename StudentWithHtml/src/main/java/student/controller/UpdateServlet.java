package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.dto.Student;

public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Student student = new Student();
		student.setAddress(req.getParameter("address"));
		student.setEmail(req.getParameter("email"));
		student.setName(req.getParameter("name"));
		student.setPassword(req.getParameter("password"));
		student.setPhone(Integer.parseInt(req.getParameter("phone")));
		
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student dbStudent =  studentDao.updateStudent(id, student);
		
		if(dbStudent != null)
		{
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("Data Updated Successfully !!!");
		}
		else
		{
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("Sorry ID is Not Present !!!");
		}
	}
}














