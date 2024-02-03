package manyToMany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manyToMany.dto.Courses;
import manyToMany.dto.Students;

public class DeleteController 
{
	public static void main(String[] args) 
	{
//		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Ansari");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		Students dbStudent=entityManager.find(Students.class, 1);
//		if(dbStudent!=null) 
//		{
//			//i can delete
//			EntityTransaction entityTransaction=entityManager.getTransaction();
//			entityTransaction.begin();
//			entityManager.remove(dbStudent);
//			entityTransaction.commit();
//		}
//		else 
//		{
//			System.out.println("Sorry id is not present");
//		}

		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Courses dbCourse=entityManager.find(Courses.class, 200);
		if(dbCourse!=null) {
			//i can delete
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();

			List<Students> students=dbCourse.getStudents();
			for(Students student:students) 
			{
				List<Courses> courses=student.getCourses();
				courses.remove(dbCourse);
				student.setCourses(courses);
			}
			entityManager.remove(dbCourse);
			entityTransaction.commit();
		}
		else 
		{
			System.out.println("Sorry id is not present");
		}
	}
}
