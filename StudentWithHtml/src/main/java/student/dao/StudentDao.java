package student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student.dto.Student;

public class StudentDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}

	public void saveStudent(Student student)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public List<Student> getAllStudents() 
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Student s");
		List<Student>students = query.getResultList();
		return students;
	}

	public Student findStudentById(int id) 
	{
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	
	public Student deleteStudentById(int id)
	{
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		if(student != null)
		{
			//id is present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
		}
		else
		{
			return null;
		}
	}
	
	public Student updateStudent(int id,Student student)
	{
		EntityManager entityManager = getEntityManager();
		Student dbStudent = entityManager.find(Student.class, id);
		if(dbStudent != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}
		else
		{
			return null;
		}
	}
}













