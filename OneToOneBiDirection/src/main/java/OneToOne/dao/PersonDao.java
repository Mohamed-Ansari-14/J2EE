package OneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToOne.dto.Person;

public class PersonDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}

	public void savePerson(Person person)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(int id,Person person)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person dbPerson = entityManager.find(Person.class, id);
		if(dbPerson != null)
		{
			entityTransaction.begin();
			person.setId(id);
			person.setAadharCard(dbPerson.getAadharCard());
			entityManager.merge(person);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present in DataBase !!!");
		}
	}
	
	public void findPerson(int id)
	{
		EntityManager entityManager = getEntityManager();
		Person dbPerson = entityManager.find(Person.class, id);
		if(dbPerson != null)
		{
			System.out.println(dbPerson);
		}
		else
		{
			System.out.println("Sorry ID is not present !!!");
		}
	}
	
	public void deletePerson(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person dbPerson = entityManager.find(Person.class, id);
		if(dbPerson != null)
		{
			entityTransaction.begin();
			entityManager.remove(dbPerson);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present in DataBase !!!");
		}
	}
}

















