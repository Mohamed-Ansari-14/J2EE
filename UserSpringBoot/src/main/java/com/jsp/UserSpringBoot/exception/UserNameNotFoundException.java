package com.jsp.UserSpringBoot.exception;

import lombok.Getter;

@Getter
public class UserNameNotFoundException extends RuntimeException
{
	private String message;

	public UserNameNotFoundException(String message) {
		super();
		this.message = message;
	}
}
