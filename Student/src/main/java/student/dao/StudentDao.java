package student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import student.dto.StudentDto;

public class StudentDao
{
	public void saveStudent(StudentDto studentDto)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit();
	}
	
	public void selectStudent(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		if(studentDto != null)
		{
			System.out.println(studentDto);
		}
		else
		{
			System.out.println("Sorry that Student-ID is Not Present !!!");
		}
	}
	
	public void updateStudent(int id,StudentDto studentDto)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		StudentDto dbStudentDto = entityManager.find(StudentDto.class, id);
		if(dbStudentDto != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			studentDto.setStuId(id);
			entityManager.merge(studentDto);
			entityTransaction.commit();
		}
		else
			System.out.println("Sorry Data is Not Present to Update !!!");
	}
	
	public void deleteStudent(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		if(studentDto != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(studentDto);
			entityTransaction.commit();
		}
		else
			System.out.println("Sorry User Not Found To Delete !!!");
	}
}
















