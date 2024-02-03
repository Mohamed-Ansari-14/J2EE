//package manyToMany.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import manyToMany.dto.Students;
//
//public class StudentsDao
//{
//	public EntityManager getEntityManager()
//	{
//		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
//	}
//	
//	public void saveStudents(Students students)
//	{
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(students);
//		entityTransaction.commit();
//	}
//}
