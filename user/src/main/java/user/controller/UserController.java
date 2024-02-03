package user.controller;

import user.dao.UserDao;
import user.dto.UserDto;

public class UserController 
{
	public static void main(String[] args)
	{
		UserDto dto = new UserDto();
		dto.setName("Mohamed");
		dto.setAddress("Chennai");
		
		UserDao dao  = new UserDao();
		dao.saveUser(dto);
		
		//dao.selectUser(2);
		//dao.deleteUser(2);
		//dao.updateUser(1, dto);
	}
}
