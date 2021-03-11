package com.vivid.vtt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivid.vtt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
//	public Optional<User> findById(long id);
	public List<User> findAll();
	
	public User findByUserId(long id);
	
	public void deleteByUserId(long id);
}
