package manyToOne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manyToOne.dto.Company;
import manyToOne.dto.Employee;

public class EmployeeDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}
	
	public void saveEmployee(Employee employee)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void saveEmployee(List<Employee>employees)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		for(Employee employee:employees)
		{
			entityManager.persist(employee);
		}
		entityTransaction.commit();
	}
	
	public void updateEmployee(int id,Employee employee)
	{
		EntityManager entityManager = getEntityManager();
		Employee dbEmployee = entityManager.find(Employee.class, id);
		if(dbEmployee != null)
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			employee.setCompany(dbEmployee.getCompany());
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry  Employee Id is Not Present to Update !!!");
		}
	}
	
	public void deleteEmployee(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee dbEmployee = entityManager.find(Employee.class, id);
		if(dbEmployee != null)
		{
			entityTransaction.begin();
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Sorry Employee ID is Not Present to Delete !!!");
		}
	}
	
	public void findEmployee(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee dbEmployee = entityManager.find(Employee.class, id);
		if(dbEmployee != null)
		{
			System.out.println(dbEmployee);
		}
		else
		{
			System.out.println("Sorry Employee ID is Not Present to Retrieve !!!");
		}
	}
}























