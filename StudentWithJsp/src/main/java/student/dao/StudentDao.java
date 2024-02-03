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
		return query.getResultList();
	}

	public void deleteStudent(int id) 
	{
		EntityManager entityManager = getEntityManager();
		Student dbStudent = entityManager.find(Student.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbStudent);
		entityTransaction.commit();
	}

	public Student findStudent(int id) 
	{
		EntityManager entityManager= getEntityManager();
		Student dbStudent = entityManager.find(Student.class, id);
		return dbStudent;
	}

	public void updateStudent(Student student)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	}
}








