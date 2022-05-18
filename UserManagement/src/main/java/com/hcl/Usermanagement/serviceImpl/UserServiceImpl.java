package com.hcl.Usermanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Usermanagement.domain.User;
import com.hcl.Usermanagement.repository.UserRepository;
import com.hcl.Usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registration(User user) {
		
		return userRepository.save(user);
	}

}
