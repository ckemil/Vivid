package com.vivid.vtt.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.vtt.dto.TicketDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Ticket;
import com.vivid.vtt.mapper.TicketMapper;
import com.vivid.vtt.repository.TicketRepository;
import com.vivid.vtt.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	TicketMapper ticketMapper;
	
	@Override
	public ResponseDto<TicketDto> getAll() {
		List<TicketDto> tickets = ticketRepo.findAll().stream().map(ticket -> {
			return ticketMapper.toDto(ticket);
		}).collect(Collectors.toList());
		System.out.println(tickets);
		
		return new ResponseDto<TicketDto>("status","message",tickets);
	}

	@Override
	public ResponseDto<TicketDto> getOne(long id) {
		Ticket ticket = ticketRepo.findById(id).get(); //need to change .get() to .orElse and throw error
		TicketDto ticketDto = ticketMapper.toDto(ticket);
		return new ResponseDto<TicketDto>("success","messsage",ticketDto);
	}

	@Override
	public ResponseDto<TicketDto> create(Ticket ticket) {
		System.out.println("----------------------2----------------------------");
		System.out.println(ticket.getCreatedBy());
		System.out.println(ticket.getCreationDate());
		ticketRepo.save(ticket);
		System.out.println("---------------------3----------------------------");
		System.out.println(ticket.getCreatedBy());
		System.out.println(ticket.getCreationDate());
		return new ResponseDto<>("SuccessS","ticket id :" +ticket.getTicketId(),null);
	}

	@Override
	public ResponseDto<TicketDto> update(Ticket ticket, long id) {
		Ticket t = ticketRepo.findById(id).get();
		if(t != null) {
			ticket.setCreatedBy(t.getCreatedBy());
			ticket.setCreationDate(t.getCreationDate());
			ticket.setTicketId(id);
			ticketRepo.save(ticket);
			return new ResponseDto<>("Successs","updated ticket " + id ,null);
		}
		return new ResponseDto<>("Failed","Ticket not avaliable", null);
	}

	@Override
	public ResponseDto<TicketDto> delete(long id) {
		if(ticketRepo.findById(id) != null) {
			ticketRepo.deleteById(id);
			return new ResponseDto<>("Successs","deleted ticket " + id ,null);
		}
		return new ResponseDto<>("Failed","Ticket not avaliable", null);
	}

	

}
