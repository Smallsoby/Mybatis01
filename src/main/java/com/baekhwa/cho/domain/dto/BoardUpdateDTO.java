package com.baekhwa.cho.domain.dto;

import org.springframework.web.bind.annotation.PathVariable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardUpdateDTO {
	
	
	private int no;
	private String title;
	private String content;

}
