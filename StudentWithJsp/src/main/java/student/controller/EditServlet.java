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

import student.dao.StudentDao;
import student.dto.Student;

@WebServlet("/edit")
public class EditServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Student student = new Student();
		student.setAddress(req.getParameter("address"));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setEmail(req.getParameter("email"));
		student.setFees(Double.parseDouble(getServletContext().getInitParameter("fees")));
		student.setId(Integer.parseInt(req.getParameter("id")));
		student.setName(req.getParameter("name"));
		student.setPassword(req.getParameter("password"));
		student.setPhone(Long.parseLong( req.getParameter("phone")));
		
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		
		StudentDao studentDao = new StudentDao();
		Student dbStudent = studentDao.findStudent(id);
		List<Student>list = studentDao.getAllStudents();
		boolean value = true;
		
		for(Student student2:list)
		{
			if(student2.getEmail().equals(email))
			{
				//It is data to be updated
				if(student2.getId()==dbStudent.getId())
					break;
				else
					value = false;
			}
		}
		
		//getting that cookie
		Cookie cookies[] = req.getCookies();
		String nameoftheStudentWhoChangedtheDetails = null;
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("studentWhoLoggedIn"))
			{
				nameoftheStudentWhoChangedtheDetails = cookie.getValue();
				break;
			}
		}
		
		if(value)
		{
			req.setAttribute("name", nameoftheStudentWhoChangedtheDetails);
			studentDao.updateStudent(student);
			req.setAttribute("list", studentDao.getAllStudents());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
		else
		{
			req.setAttribute("message", "Sorry Email already exist !!!");
			req.setAttribute("student", dbStudent);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}




















