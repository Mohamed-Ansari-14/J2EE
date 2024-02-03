package com.jsp.spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController
{
	@RequestMapping("/first")
	public String firstApi()
	{
		return "Yes I have Created my First Api";
	}
	
	@RequestMapping("/second")
	public String secondApi()
	{
		return "Yes I have Created my second Api";
	}
}
