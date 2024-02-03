package onetomanye3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanye3.dto.Company;
import onetomanye3.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Ansari").createEntityManager();
	}

	public void saveEmployee(int companyId,Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present then i can join to this company
			entityTransaction.begin();	
			entityManager.persist(employee);
//			im taking old employee deatils
	        List<Employee> employees=dbCompany.getEmployees();
//	        im adding new employee to the group of old emp
			employees.add(employee);		
//			now im going to reset the values
			dbCompany.setEmployees(employees);
			entityTransaction.commit();
		}else {
//			that company is not present
			System.out.println("Sorry companyID Not present/company doesnot exist");
		}
	}
	
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			EntityTransaction  entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	
	public void findEMployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			System.out.println(dbEmployee);
		}else {
//			id is not present
			System.out.println("Sorry id is not present");
		}
	}
	
	
	public void deleteEMployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}else {
//			id is not present
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
