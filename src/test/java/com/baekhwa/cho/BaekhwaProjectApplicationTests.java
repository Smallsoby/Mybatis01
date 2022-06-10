package com.baekhwa.cho;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baekhwa.cho.domain.dto.BoardDTO;
import com.baekhwa.cho.domain.dto.BoardInsertDTO;
import com.baekhwa.cho.domain.dto.MemberDTO;
import com.baekhwa.cho.domain.dto.MemberInsertDTO;
import com.baekhwa.cho.domain.dto.MemberUpdateDTO;
import com.baekhwa.cho.mybatis.mapper.BoardMapper;
import com.baekhwa.cho.mybatis.mapper.MemberMapper;

@SpringBootTest
class BaekhwaProjectApplicationTests {

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	BoardMapper boardMapper;
	
	//@Test
	void 더미데이터() {
		IntStream.rangeClosed(1, 200).forEach(i->{
			boardMapper.save(BoardInsertDTO.builder()
					.title("제목"+i).content("내용"+i).writer("test01@test.com")
					.build());
		});
	}
	
	///////////////////////////
	
	//@Test
	void 멤버삽입테스트() {
		int r=mapper.save(MemberInsertDTO.builder()
				.email("test02@test.com").name("test01").pass("1111")
				.build());
		//update 된 rows 수 리턴
		System.out.println(r+"개의 회원정보를 삽입하였습니다.");
	}
	//
	//@Test
	void 비밀번호수정() {
		MemberUpdateDTO dto=MemberUpdateDTO.builder()
				.no(2).pass("2222")
				.build();
		//먼저 대상이 존재하는지 체크
		Optional<MemberDTO> result= mapper.selectById(dto.getNo());
		if(result.isEmpty()) {
			System.out.println(">>>존재하지않는 회원");return;
		}
		
		mapper.update(dto);
	}
	
	////////////////////////////////////////////////////////
	
	

}
