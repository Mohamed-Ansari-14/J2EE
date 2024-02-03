package com.jsp.UserSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.UserSpringBoot.dto.User;
import com.jsp.UserSpringBoot.service.UserService;
import com.jsp.UserSpringBoot.util.ResponseStructure;

@RestController
public class UserController //in this layer we receiving the JSON and sending that to Dao and Returning...
{							//the response to the postman.
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}

	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserById(@RequestParam int id)	//->@RequestParam used to request for single argument
	{
		return service.findUserById(id);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUserById(@RequestParam int id)
	{
		return service.deleteUserById(id);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUserById(@RequestParam int id,@RequestBody User user)
	{
		return service.updateUser(id,user);
	}

	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		return service.findAllUsers();
	}
	
	@GetMapping("/findbyname")
    public ResponseEntity<ResponseStructure<List<User>>> findStudentByName(@RequestParam String name)
	{
		return service.findStudentByName(name);
	}	
}












