package com.hcl.UserManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.UserManagement.domain.User;
import com.hcl.UserManagement.repository.UserRepository;
import com.hcl.UserManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registration(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User update(String username,Long id) {
		
			Optional<User>userFromDb=userRepository.findById(id);
			if(!userFromDb.isEmpty()) {
			
			User user=userFromDb.get();
				user.setId(id);
				user.setUsername(username);
				
				 userRepository.save(user);
		}
			return userFromDb.get();
		
	}
	public User user(String username, String password) {
		 // User user = userRepository.findByUsernameAndPassword(username, password);
		 // System.out.println("user"+user);
		 //  return user;
		User userresult=null;
		List<User> userlist= userRepository.findAll();
		System.out.println(userlist);
		for(User user:userlist) {
			System.out.println("username "+user.getUsername());
			System.out.println("password "+user.getPassword());
			System.out.println(user.getUsername().equals(username));
			System.out.println(user.getPassword().equals(password));
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				userresult=user;
				System.out.println("userresultcase2");
			}
					
		}
		return userresult;
		  }
		 

}
