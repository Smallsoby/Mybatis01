package com.baekhwa.cho.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.baekhwa.cho.domain.dto.BoardInsertDTO;
import com.baekhwa.cho.domain.dto.BoardUpdateDTO;
import com.baekhwa.cho.domain.dto.LoginDTO;
import com.baekhwa.cho.service.BoardService;
import com.baekhwa.cho.service.impl.BoardServiceProc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//데이터베이스 정보 읽어와서 리스트페이지 이동
	@GetMapping("/board")
	public String list(Model model) {
		//db에서 데이터 읽어올꼐요...
		//페이지에 전달
		
		service.boardListAll(model);		
		return "view/board/list";
	}
	//write page move
	@GetMapping("/board/write")
	public String write(HttpSession session) {
		LoginDTO loginfo=(LoginDTO) session.getAttribute("loginfo");
		
		if(loginfo==null) {
			//로그인이 되지 않은경우에는 이동불가
			return "redirect:/signin";
		}
		
		return "view/board/write";//페이지(html file) 정보
	}
	//글쓰기 입력 처리
	@PostMapping("/board/write")
	public String write(BoardInsertDTO dto) {
		log.debug(">>>>"+dto);
		//BoardInsertDTO 를 db에 저장하기
		service.save(dto);
		return "redirect:/board"; //"view/board/list"(X)
	}
	//detail page process
	@GetMapping("/board/{bno}")// "/board/detail?no=3"
	public String detail(@PathVariable("bno") int no, Model model) {
		System.out.println("no: "+no);
		//what????
		//use no then select db data
		service.detail(no, model);
		//???page + detail-data
		return "view/board/detail";
	}
	//PutMapping 으로 조정할꼐요
	@PostMapping("/board/{no}")
	public String update(/* @PathVariable int no, */BoardUpdateDTO dto) {
		
		service.update(dto);
		//System.out.println(dto);
		
		return "redirect:/board/"+dto.getNo(); // get "/board/{no}"
	}
	
	//spring.mvc.hiddenmethod.filter.enabled=true
	//properties에서 설정해야 사용가능합니다..
	@ResponseBody
	@DeleteMapping("/board/{no}")
	public void delete(@PathVariable int no) {
		//System.out.println("delete__no:: "+no);
		
		service.delete(no);
	}
}






