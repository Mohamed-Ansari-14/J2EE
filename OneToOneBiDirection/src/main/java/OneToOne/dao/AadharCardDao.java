package OneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToOne.dto.AadharCard;
import OneToOne.dto.Person;

public class AadharCardDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}

	public void saveAadharCard(int personId,AadharCard aadharCard)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, personId);
		if(person!=null)
		{
			entityTransaction.begin();
			person.setAadharCard(aadharCard);
			entityManager.persist(aadharCard);
			entityTransaction.commit();
		}
		else 
		{
			System.out.println("sorry that person not exist");
		}
	}

	public void updateAadharCard(int id,AadharCard aadharCard)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if(dbAadharCard != null)
		{
			entityTransaction.begin();
			aadharCard.setId(id);
			aadharCard.setPerson(dbAadharCard.getPerson());
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present in DataBase !!!");
		}
	}

	public void findAadharCard(int id)
	{
		EntityManager entityManager = getEntityManager();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if(dbAadharCard != null)
		{
			System.out.println(dbAadharCard);
		}
		else
		{
			System.out.println("Sorry ID is not present !!!");
		}
	}

	public void deleteAadharCard(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if(dbAadharCard != null)
		{
			entityTransaction.begin();

			Person person = dbAadharCard.getPerson();
			//in your SQL point of view you have reached Person Table.
			person.setAadharCard(null);
			entityManager.remove(dbAadharCard);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present in DataBase !!!");
		}
	}
}



















