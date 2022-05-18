package com.hcl.Usermanagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Usermanagement.domain.User;
import com.hcl.Usermanagement.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	public User registerNewUser(@RequestBody User user ) {
		User savedUser = userService.registration(user);
		return savedUser;
	}

}
