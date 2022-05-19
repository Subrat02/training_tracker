package com.hcl.UserManagement.service;

import com.hcl.UserManagement.domain.User;

public interface UserService {
	public User registration(User user);

	public User update(String username, Long id);

	public User user(String username, String password);
	

}
