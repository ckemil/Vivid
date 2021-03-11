package com.vivid.vtt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivid.vtt.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	public List<Ticket> findAll();
	
	public Optional<Ticket> findById(Long id);
}
