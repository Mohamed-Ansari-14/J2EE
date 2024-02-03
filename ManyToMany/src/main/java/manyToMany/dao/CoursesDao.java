package manyToMany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manyToMany.dto.Courses;

public class CoursesDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}
	
	public void saveCourses(Courses courses)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
	}
	
	public void findCourses(int id)
	{
		EntityManager entityManager = getEntityManager();
		Courses dbCourses = entityManager.find(Courses.class, id);
		if(dbCourses != null)
		{
			System.out.println(dbCourses);
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void deleteCourses(int id)
	{
		EntityManager entityManager = getEntityManager();
		Courses dbCourses = entityManager.find(Courses.class, id);
		if(dbCourses != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCourses);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void updateCourses(int id,Courses courses)
	{
		EntityManager entityManager = getEntityManager();
		Courses dbCourses = entityManager.find(Courses.class, id);
		if(dbCourses != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			courses.setId(id);
			entityManager.merge(dbCourses);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry Id is Not Present !!!");
		}
	}
}





















