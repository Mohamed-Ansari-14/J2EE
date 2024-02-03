package onetonee3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetonee3.dto.AadharCard;
import onetonee3.dto.Person;

public class AadharCardDao 
{
	public EntityManager getEntityManager() 
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveAadharCard(int personId,AadharCard aadharCard) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, personId);
		if(person!=null) {
//			that person is a valid person
			entityTransaction.begin();
			person.setAadharCard(aadharCard);
			entityManager.persist(aadharCard);
			entityTransaction.commit();
		}else {
//			that id is not present
//			that person doesnot exist
			System.out.println("sorry that person not exist");
		}
	}
	
	public void findAadharCard(int id)
	{
		EntityManager entityManager=getEntityManager();
		AadharCard aadharCard=entityManager.find(AadharCard.class, id);
		if(aadharCard!=null) 
		{
//			person id is present
			System.out.println(aadharCard);
		}
		else 
		{
			System.out.println("Sorry that id is Not Present");
		}
	}
	
	public void updateAadharCard(int id,AadharCard aadharCard) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) 
		{
//		 id is present then i can update the data
			entityTransaction.begin();
			aadharCard.setId(id);
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry that id is Not Present");
		}
	}
	
	public void deleteAadhar(int id) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		AadharCard aadharCard=entityManager.find(AadharCard.class, id);
		if(aadharCard!=null) 
		{
//			person id is present
			entityTransaction.begin();
			entityManager.remove(aadharCard);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry that id is Not Present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
