package user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import user.dto.UserDto;

public class UserDao
{
	public void saveUser(UserDto user)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	public void selectUser(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDto userDto = entityManager.find(UserDto.class, id);
		if(userDto != null)
		{
			System.out.println(userDto);
		}
		else
		{
			System.out.println("Sorry that ID is Not Present !!!");
		}
	}
	
	public void deleteUser(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDto userDto = entityManager.find(UserDto.class,id);
		if(userDto != null)
		{
			//id is Present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(userDto);
			entityTransaction.commit();
		}
		else
		{
			//id is not present
			System.out.println("Sorry User Not Found To Delete !!!");
		}
	}
	
	public void updateUser(int id, UserDto userDto)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDto dbUserDto = entityManager.find(UserDto.class, id);
		if(dbUserDto != null)
		{
			//id is present i can Update the data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			//very important line
			userDto.setId(id);
			entityManager.merge(userDto);
			entityTransaction.commit();
		}
		else
		{
			//id is not present
			System.out.println("Sorry Data is Not Present to Update !!!");
		}
	}
}












