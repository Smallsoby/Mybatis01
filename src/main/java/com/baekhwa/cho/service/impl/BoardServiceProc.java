package com.baekhwa.cho.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baekhwa.cho.domain.dto.BoardDTO;
import com.baekhwa.cho.domain.dto.BoardListDTO;
import com.baekhwa.cho.mybatis.mapper.BoardMapper;
import com.baekhwa.cho.service.BoardService;

@Service
public class BoardServiceProc implements BoardService {
	
	//dao ???
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void boardListAll(Model model) {
		
		//List<BoardDTO> to List<BoardListDTO>
		List<BoardListDTO> result=mapper.findAll()
									.stream()
									.map(BoardListDTO::new)//BoardDTO-->BoardListDTO : BoardListDTO(BoardDTO)
									.collect(Collectors.toList());
		model.addAttribute("list", result);
		
	}

}
