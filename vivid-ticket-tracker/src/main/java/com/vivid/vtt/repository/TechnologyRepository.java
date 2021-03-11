package com.vivid.vtt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivid.vtt.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
	
	public List<Technology> findAll();
	
	//public Technology findBytechId();

}
