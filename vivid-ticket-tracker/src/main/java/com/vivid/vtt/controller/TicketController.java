package com.vivid.vtt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.vtt.dto.TicketDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Ticket;
import com.vivid.vtt.service.TicketService;

@RestController
@RequestMapping(value="/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/all")
	ResponseDto<TicketDto> listTicket(){
		
		return ticketService.getAll();
	}
	
	@GetMapping("/{id}")
	ResponseDto<TicketDto> getTicket(@PathVariable(value = "id") long id){
		return ticketService.getOne(id);
	}
	
	@PostMapping("/new")
	ResponseDto<TicketDto> create(@RequestBody Ticket ticket){
		System.out.println("----------------------1----------------------------");
		System.out.println(ticket.getCreatedBy());
		System.out.println(ticket.getCreationDate());
		return ticketService.create(ticket);
	}
	@PutMapping("/{id}")
	ResponseDto<TicketDto> update(@PathVariable(value = "id") long id,@RequestBody Ticket ticket){
		return ticketService.update(ticket, id);
	}
	
	@DeleteMapping("/{id}")
	ResponseDto<TicketDto> delete(@PathVariable(value = "id") long id){
		return ticketService.delete(id);
	}
}
