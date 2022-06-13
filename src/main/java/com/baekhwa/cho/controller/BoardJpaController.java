package com.baekhwa.cho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baekhwa.cho.service.BoardJpaService;
import com.baekhwa.cho.service.impl.BoardJpaServiceProc;

@Controller
public class BoardJpaController {
	
	@Autowired
	private BoardJpaService boardJpaService;
	
	@GetMapping("/boardjpa")
	public String list(Model model) {
		//데이터 갖고가야죠:Model객체를 통해서 view에 데이터 전달
		//페이지 이동
		return "view/boardjpa/list";
	}

}
