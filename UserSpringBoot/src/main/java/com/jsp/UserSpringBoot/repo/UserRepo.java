package com.jsp.UserSpringBoot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.UserSpringBoot.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	@Query("select u from User u where u.name=?1")
	public Optional<List<User>> findByName(String name);
}
