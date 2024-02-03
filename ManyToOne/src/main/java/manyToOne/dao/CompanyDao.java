package manyToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manyToOne.dto.Company;

public class CompanyDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}
	
	public void saveCompany(Company company)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int id,Company company)
	{
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);
		if(dbCompany != null)//if that id is present i can update the data...
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			entityManager.merge(company);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry Company ID is not Present to Update !!!");
		}
	}
	
	public void deleteCompany(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company dbCompany = entityManager.find(Company.class, id);
		if(dbCompany != null)
		{
			entityTransaction.begin();
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry Company ID is Not Present to Delete !!!");
		}
	}
	
	public void findCompany(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company dbCompany = entityManager.find(Company.class, id);
		if(dbCompany != null)
		{
			System.out.println(dbCompany);
		}
		else
		{
			System.out.println("Sorry Company ID is Not Present to Retrieve !!!");
		}
	}
}





















