package com.vivid.vtt.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateMapper {

	public String asString(LocalDateTime dateTime) {

		String formatedDate = "";
		if (dateTime != null) {
			String datePattern = "dd-MM-yyyy";
			formatedDate = formatedDate + dateTime.format(DateTimeFormatter.ofPattern((datePattern)));
		}
		return formatedDate;
	}

	public LocalDateTime asDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

		return dateTime;

	}
}
