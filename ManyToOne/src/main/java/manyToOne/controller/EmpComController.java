package manyToOne.controller;

import java.util.ArrayList;
import java.util.List;

import manyToOne.dao.CompanyDao;
import manyToOne.dao.EmployeeDao;
import manyToOne.dto.Company;
import manyToOne.dto.Employee;

public class EmpComController
{
	public static void main(String[] args)
	{
//		Company company = new Company();
//		company.setId(100);
//		company.setName("TCS");
//		company.setGst("Tcs@123");
//		
//		Employee employee1 = new Employee();
//		employee1.setId(1);
//		employee1.setName("Deepan");
//		employee1.setAddress("Chennai");
//		
//		employee1.setCompany(company);
//		
//		Employee employee2 = new Employee();
//		employee2.setId(2);
//		employee2.setName("Bhuvanesh");
//		employee2.setAddress("Banglore");
//		
//		employee2.setCompany(company);
//		
//		Employee employee3 = new Employee();
//		employee3.setId(3);
//		employee3.setName("Gopi");
//		employee3.setAddress("Mumbai");
//		
//		employee3.setCompany(company);
//		
//		CompanyDao companyDao = new CompanyDao();
//		EmployeeDao employeeDao = new EmployeeDao();
//		
//		companyDao.saveCompany(company);
//
//	    
//	    List<Employee> employees=new ArrayList<Employee>();
//	    employees.add(employee1);
//	    employees.add(employee2);
//	    employees.add(employee3);
//	    
//	    employeeDao.saveEmployee(employees);
		
		//Update !!!
		
//		Employee employee = new Employee();
//		employee.setName("Ansari");
//		employee.setAddress("Tenkasi");
//		
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.updateEmployee(2, employee);
//		
//		Company company = new Company();
//		company.setName("Tata");
//		company.setGst("TCS@123");
//		
//		CompanyDao companyDao = new CompanyDao();
//		companyDao.updateCompany(100, company);
		
		//Select !!!
		
//		CompanyDao companyDao = new CompanyDao();
//		companyDao.findCompany(100);
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.findEmployee(2);
		
		//Delete !!!
		
		CompanyDao companyDao = new CompanyDao();
		companyDao.deleteCompany(100);
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(3);
		
	}
}










