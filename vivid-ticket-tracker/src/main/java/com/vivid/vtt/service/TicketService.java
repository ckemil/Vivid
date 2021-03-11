package com.vivid.vtt.service;

import com.vivid.vtt.dto.TicketDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Ticket;

public interface TicketService {
	
	public ResponseDto<TicketDto> getAll();
	
	public ResponseDto<TicketDto> getOne(long id);
	
	public ResponseDto<TicketDto> create(Ticket ticket);
	
	public ResponseDto<TicketDto> update(Ticket ticket, long id);
	
	public ResponseDto<TicketDto> delete(long id);
	

}
