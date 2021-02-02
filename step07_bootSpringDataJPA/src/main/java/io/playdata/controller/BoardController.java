package io.playdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.BoardRepository;
import io.playdata.model.domain.Board;

@RestController
public class BoardController {
	@Autowired
	private BoardRepository dao;
	
	@PostMapping("board")
	public String m1(Long i) {
		Board board1 =  new Board(i,"Spring Boot", "김재웅", "스프링 앱을 쉽게 개발 가능하게 해주는");
		dao.save(board1); 
		return "게시판 저장 성공";
	}
	
	//getboard?id=1
	@GetMapping("getboard")
	public Board m2(Long id) {
		return dao.findById(id).get();
	}
	
	@GetMapping("boardall")
	public Iterable<Board> m3() {
		return dao.findAll();
	}
	
	@GetMapping("board-title")
	public List<Board> m4(String title) {
		return dao.findBoardByTitle(title);
	}
	
	@GetMapping("board-title-search")
	public List<Board> m5(String search) {
		return dao.findBoardByTitleContaining(search);
	}
	
}
