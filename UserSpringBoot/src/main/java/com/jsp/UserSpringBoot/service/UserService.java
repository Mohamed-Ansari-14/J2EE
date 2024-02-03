package com.jsp.UserSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.UserSpringBoot.dao.UserDao;
import com.jsp.UserSpringBoot.dto.User;
import com.jsp.UserSpringBoot.exception.UserIdNotFoundException;
import com.jsp.UserSpringBoot.exception.UserNameNotFoundException;
import com.jsp.UserSpringBoot.util.ResponseStructure;

@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		User dbUser = userDao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("Data Saved Sucessfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) 
	{
		User user = userDao.findUserById(id);
		if(user != null)
		{
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Fetched Sucessfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		else
		{
			//Id is not Present
			throw new UserIdNotFoundException("Sorry Failed to Fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id)
	{
		User user = userDao.deleteUserById(id);
		if(user != null)
		{
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Deleted Sucessfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		else
		{
			//Id is not Present
			throw new UserIdNotFoundException("Sorry Failed to Delete the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) 
	{
		User dbUser = userDao.updateUser(id, user);
		if(dbUser != null)
		{
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Updated Sucessfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		else
		{
			//Id is not Present
			throw new UserIdNotFoundException("Sorry Failed to Update the data");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		List<User> users = userDao.findAllUsers();
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setMessage("Data Fetched Sucessfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(users);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findStudentByName(String name) 
	{
		List<User> users = userDao.findUserByName(name);
		
		if(users.isEmpty())
			throw new UserNameNotFoundException("Sorry Failed to Fetch the User");	//user is not present with that name
		else
		{
			ResponseStructure<List<User>> structure=new ResponseStructure<>();
			structure.setMessage("Data Fetched Successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(users);
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
	}
}













