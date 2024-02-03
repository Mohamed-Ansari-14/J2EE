package student.controller;

import student.dao.StudentDao;
import student.dto.StudentDto;

public class StudentController 
{
	public static void main(String[] args) 
	{
		StudentDto student = new StudentDto();
//		
//		student.setStuId(id);
		student.setName("Wasim");
		student.setAddress("Chennai");
//		
		StudentDao dao = new StudentDao();
//		dao.saveStudent(student);
//		dao.selectStudent(1);
//		dao.updateStudent(4, student);
		dao.deleteStudent(4);
	}
}
