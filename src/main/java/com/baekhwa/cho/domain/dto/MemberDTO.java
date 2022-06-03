package com.baekhwa.cho.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

//db select 결과와 매핑되는 클래스로 사용
@Data
public class MemberDTO {
	
	private long no;
	private String email;
	private String name;
	private String pass;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
