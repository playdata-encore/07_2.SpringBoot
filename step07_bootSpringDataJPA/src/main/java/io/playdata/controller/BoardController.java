package io.playdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.dao.BoardRepository;
import io.playdata.model.domain.Board;


@RestController
public class BoardController {
	@Autowired
	private BoardRepository dao;
	
	@PostMapping("board")
	public Board m1(Long i) {
		Board board1 =  new Board(i,"Spring Boot", "재웅", "스프링 앱을 쉽게 개발 가능하게 해주는");
		dao.save(board1); 
		return board1;
	}
	
	//getboard?id=1
	@GetMapping("getboard")
	public Board m2(Long id) {
		return dao.findById(id).orElse(null);
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
	
	//호출하는 테스트 코드는 직접 구현해보자
	// select * from board where seq=? and writer=?
	@GetMapping("board-seq-writer-search")
	List<Board> m6(Long seq, String writer) {
		return dao.findBoardBySeqAndWriter(seq, writer);
	}	
	
	//***
	/*
		{ "seq": 115, "title": "java", "writer":"재웅", "content": "파이썬"}
	 
	 */
	@PostMapping("newboard")
	public String m7(@RequestBody Board data) {
		return dao.save(data) + "저장 성공";
	}

	@PostMapping("newboardpath/{title}") // 일단 포스트 겟 둘다 되는듯
	public String m8(@PathVariable String title) {
		return title + "출력 성공";
	}

}

//API를 사용하는 개념으로 

/*

@Controller 기반의 클래스에서 빈번히 사용하는 애노테이션
jsp로 이동없이 JSON 포맷으로 바로 응답할 경우 사용하는 애노테이션

	@ResponseBody 이런것도 좀 찾아보자

 */



