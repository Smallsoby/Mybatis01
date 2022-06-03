package com.baekhwa.cho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baekhwa.cho.domain.dto.MemberInsertDTO;
import com.baekhwa.cho.mybatis.mapper.MemberMapper;
import com.baekhwa.cho.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceProc implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void save(MemberInsertDTO dto) {
		// DB에 dto정보 저장
		//필요한게 무엇일까요?
		//DB접근(jpa,my) DAO(repository 객체, mapper객체)은 무엇으로 결정?
		int result=mapper.save(dto);
		
		log.debug(result+"명의 회원가입 정상완료!");
	}

}
