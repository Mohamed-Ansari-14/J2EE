package manyToMany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manyToMany.dto.Students;

public class StudentsDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}
	
	public void saveStudents(Students students)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(students);
		entityTransaction.commit();
	}
	
	public void findStudents(int id)
	{
		EntityManager entityManager = getEntityManager();
		Students dbStudents = entityManager.find(Students.class, id);
		if(dbStudents != null)
		{
			System.out.println(dbStudents);
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void deleteStudents(int id)
	{
		EntityManager entityManager = getEntityManager();
		Students dbStudents = entityManager.find(Students.class, id);
		if(dbStudents != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudents);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void updateStudents(int id,Students students)
	{
		EntityManager entityManager = getEntityManager();
		Students dbStudents = entityManager.find(Students.class, id);
		if(dbStudents != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			students.setId(id);
			students.setCourses(dbStudents.getCourses());
			entityManager.merge(dbStudents);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void findStudentByName(String name)
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Students s where s.name=?1");
		query.setParameter(1, name);
		
		List<Students> students =  query.getResultList();
		
		if(students.isEmpty())
		{
			System.out.println("Sorry Student not Exist in that name !!!");
		}
		else
		{
			for(Students student:students)
			{
				System.out.println(student);
			}
		}
	}
	
	public void findAllStudent()
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Students s");
		List<Students>students = query.getResultList();
		System.out.println(students);
	}
}















