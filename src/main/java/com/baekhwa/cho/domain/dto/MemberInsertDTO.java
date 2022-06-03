package com.baekhwa.cho.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class MemberInsertDTO {
	
	private String email;
	private String name;
	private String pass;

}
