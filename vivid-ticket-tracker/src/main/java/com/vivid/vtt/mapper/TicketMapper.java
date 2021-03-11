package com.vivid.vtt.mapper;

import org.mapstruct.Mapper;


import com.vivid.vtt.dto.TicketDto;
import com.vivid.vtt.entity.Ticket;

@Mapper(uses = {DateMapper.class})
public interface TicketMapper {
	

	Ticket fromDto(TicketDto ticketDto);
	
	TicketDto toDto(Ticket ticket);
	
	

}
