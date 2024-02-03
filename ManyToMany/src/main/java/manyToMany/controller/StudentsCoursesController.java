package manyToMany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import manyToMany.dao.CoursesDao;
import manyToMany.dao.StudentsDao;
import manyToMany.dto.Courses;
import manyToMany.dto.Students;

public class StudentsCoursesController 
{
	public static void main(String[] args) 
	{
//		Courses courses1 = new Courses();
//		courses1.setId(100);
//		courses1.setName("Core-Java");
//		courses1.setFees(15000);
//		
//		Courses courses2 = new Courses();
//		courses2.setId(200);
//		courses2.setName("Advance-Java");
//		courses2.setFees(25000);
//		
//		Courses courses3 = new Courses();
//		courses3.setId(300);
//		courses3.setName("SQL");
//		courses3.setFees(8000);
//		
//		Students student1 = new Students();
//		student1.setId(1);
//		student1.setName("Gopi");
//		student1.setAddress("Chennai");
//		
//		List<Courses>coursesOfStudent1 = new ArrayList<Courses>();
//		coursesOfStudent1.add(courses1);
//		coursesOfStudent1.add(courses3);
//		student1.setCourses(coursesOfStudent1);
//		
//		Students student2 = new Students();
//		student2.setId(2);
//		student2.setName("Deepan");
//		student2.setAddress("Ramapuram");
//		student2.setCourses(coursesOfStudent1);
//		
//		Students student3 = new Students();
//		student3.setId(3);
//		student3.setName("Hema");
//		student3.setAddress("Urappakam");
//		
//		List<Courses>coursesOfStudent2 = new ArrayList<Courses>();
//		coursesOfStudent2.add(courses1);
//		coursesOfStudent2.add(courses2);
//		coursesOfStudent2.add(courses3);
//		student3.setCourses(coursesOfStudent2);
//		
//		CoursesDao coursesDao=new CoursesDao();
//		coursesDao.saveCourses(courses1);
//		coursesDao.saveCourses(courses2);
//		coursesDao.saveCourses(courses3);
//		
//		StudentsDao studentsDao = new StudentsDao();
//		studentsDao.saveStudents(student1);
//		studentsDao.saveStudents(student2);
//		studentsDao.saveStudents(student3);
		
		//Find !!!
		
//		StudentsDao studentsDao = new StudentsDao();
//		studentsDao.findStudents(1);
//		CoursesDao coursesDao = new CoursesDao();
//		coursesDao.findCourses(100);
		
		//Find By Name !!!
		
		StudentsDao studentsDao = new StudentsDao();
		studentsDao.findStudentByName("Hema");
		
		//Find All Students !!!
		studentsDao.findAllStudent();
		
		//Update !!!
		
		
		
		
		
		
		//Delete
		
	}
}





















