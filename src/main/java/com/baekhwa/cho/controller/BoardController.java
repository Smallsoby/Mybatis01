package com.baekhwa.cho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baekhwa.cho.service.BoardService;
import com.baekhwa.cho.service.impl.BoardServiceProc;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board")
	public String list(Model model) {
		//db에서 데이터 읽어올꼐요...
		//페이지에 전달
		
		service.boardListAll(model);		
		return "view/board/list";
	}

}
