package manyToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import manyToMany.dao.CoursesDao;
//import manyToMany.dao.StudentsDao;
import manyToMany.dto.Courses;
import manyToMany.dto.Students;

public class StudentsCoursesController 
{
	public static void main(String[] args)
	{
		Courses courses1 = new Courses();
		courses1.setId(100);
		courses1.setName("Core-Java");
		courses1.setFees(15000);
		
		Courses courses2 = new Courses();
		courses2.setId(200);
		courses2.setName("Advance-Java");
		courses2.setFees(20000);
		
		List<Courses>coursesOfOne = new ArrayList<Courses>();
		coursesOfOne.add(courses1);
		coursesOfOne.add(courses2);
		
		Students student1 = new Students();
		student1.setId(1);
		student1.setName("Mohamed");
		student1.setAddress("Chennai");
		
		Students student2 = new Students();
		student2.setId(2);
		student2.setName("Ansari");
		student2.setAddress("Bangalore");
		
		student1.setCourses(coursesOfOne);
		student2.setCourses(coursesOfOne);
		
		List<Students>students = new ArrayList<Students>();
		students.add(student1);
		students.add(student2);
		
		courses1.setStudents(students);
		courses2.setStudents(students);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityTransaction.commit();
		
	}
}






















