package com.baekhwa.cho.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class BoardDTO {
	
	private long no;
	private String title;
	private String content;
	private String writer;
	private int readCount;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
