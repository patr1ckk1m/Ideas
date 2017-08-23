package com.patrick.belt1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.patrick.belt1.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
