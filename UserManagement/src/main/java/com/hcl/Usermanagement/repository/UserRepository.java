package com.hcl.Usermanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Usermanagement.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
