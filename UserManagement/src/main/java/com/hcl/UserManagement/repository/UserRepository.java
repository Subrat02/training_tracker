package com.hcl.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.UserManagement.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//User findByUsernameAndPassword(String username,String password);
	//@Query("select User user where user.password=:password where user.username= :username")
	//User findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	

}
