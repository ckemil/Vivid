package com.vivid.vtt.dto.common;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDto<T> {
	
private String status;
	
	private String message;
	
	private T data;
	
	private List<T> dataItems;
	
	public ResponseDto() {
		super();
	}

	public ResponseDto(String status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public ResponseDto(String status, String message, List<T> dataItems) {
		super();
		this.status = status;
		this.message = message;
		this.dataItems = dataItems;
	}
}
