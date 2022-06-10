package com.baekhwa.cho.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baekhwa.cho.domain.dto.BoardDTO;
import com.baekhwa.cho.domain.dto.BoardInsertDTO;
import com.baekhwa.cho.domain.dto.BoardListDTO;
import com.baekhwa.cho.domain.dto.BoardUpdateDTO;
import com.baekhwa.cho.mybatis.mapper.BoardMapper;
import com.baekhwa.cho.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceProc implements BoardService {
	
	//dao ???
	@Autowired
	private BoardMapper mapper;
	
	//페이징 처리해서 리스트 갖고오기
	@Override
	public void boardList(int pageNo, Model model) {
		int limit=5;
		int offset=limit * (pageNo-1);//현실의 1번페이지는 offset의 0
		List<BoardListDTO> result=mapper.select(offset,limit);
		model.addAttribute("list", result);
	}
	
	@Override
	public void boardListAll(Model model) {
		
		//List<BoardDTO> to List<BoardListDTO>
		List<BoardListDTO> result=mapper.findAll()
									.stream()
									.map(BoardListDTO::new)//BoardDTO-->BoardListDTO : BoardListDTO(BoardDTO)
									.collect(Collectors.toList());
		model.addAttribute("list", result);
		
	}

	@Override
	public void save(BoardInsertDTO dto) {
		// DB save : who? : dao
		int n=mapper.save(dto);
		//n db에서 변경된데이터 정보 리턴
	}

	//상세정보 불러와서 모델에 담기
	@Override
	public void detail(int no, Model model) {
		BoardDTO result=mapper.findById(no).orElseThrow();
		model.addAttribute("detail", result);
	}

	@Override
	public void update(BoardUpdateDTO dto) {
		int n=mapper.update(dto);
		log.debug(n+"개의 데이터 수정완료!");
		
	}

	@Override
	public void delete(int no) {
		int n=mapper.deleteById(no);
		log.debug(n+"개의 데이터 삭제완료!");
	}

	
	

	

}
