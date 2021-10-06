package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {

	public Iterable<User> findAll();
	
	//public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
}
