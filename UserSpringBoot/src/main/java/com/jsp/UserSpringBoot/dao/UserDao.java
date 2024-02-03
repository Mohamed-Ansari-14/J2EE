package com.jsp.UserSpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.UserSpringBoot.dto.User;
import com.jsp.UserSpringBoot.repo.UserRepo;

@Repository
public class UserDao //in this Layer we saving and returning saved data...
{
	@Autowired
	private UserRepo userRepo;
	
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findUserById(int id)
	{//Optional is a java 8 feature used to avoid null pointer exception
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent())
		{
			User user = optional.get();
			return user;
		}
		else
			return null;
	}

	public User deleteUserById(int id)
	{
		Optional<User>optional = userRepo.findById(id);
		if(optional.isPresent())
		{
			//if user is present i can delete Data.
			User user = optional.get();
			userRepo.delete(user);
			return user;
		}
		return null;
	}

	public User updateUser(int id, User user)
	{
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent())
		{
			user.setId(id);
			return userRepo.save(user);
		}
		return null;
	}
	
	public List<User> findAllUsers()
	{
		return userRepo.findAll();
	}

	public List<User> findUserByName(String name) 
	{
		Optional<List<User>> optional = userRepo.findByName(name);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
}







