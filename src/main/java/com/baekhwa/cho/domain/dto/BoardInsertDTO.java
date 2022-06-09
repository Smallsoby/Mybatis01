package com.baekhwa.cho.domain.dto;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter// 컨트롤러에 파라미터 매핑을 위해서
public class BoardInsertDTO {
	
	private String title;
	private String content;
	private String writer;

}
