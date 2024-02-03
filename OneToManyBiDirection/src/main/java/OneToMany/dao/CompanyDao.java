package OneToMany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToMany.dto.Company;
import OneToMany.dto.Employee;

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
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company dbCompany = entityManager.find(Company.class, id);
		if(dbCompany != null)
		{
			entityTransaction.begin();
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
	
	public void findCompany(int id)
	{
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);
		if(dbCompany != null)
		{
			System.out.println(dbCompany);
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
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
			List<Employee>employees = dbCompany.getEmployees();//-->Breaking the Relationship 
			for(Employee employee:employees)//-->Iterate every employees and break the relationship with company
			{
				employee.setCompany(null);
			}
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry ID is Not Present !!!");
		}
	}
}



















