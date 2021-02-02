package io.playdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.model.domain.Board;

@RestController
public class Controller {

	public Controller() {
		System.out.println("컨트롤러 기본생성자 생성");
	}
	
	//GET - http://localhost:80/hello
	@GetMapping("hello")
	public String m1() {
		return "안녕!";
	}
	
	//GET - http://localhost:80/hello2?id=tester
	@GetMapping("hello2")
	public String m2(String id) {
		return id;
	}
	
	//GET - http://localhost:80/board
	@GetMapping("board")
	public Board m3() {
		return new Board(1,"Spring Boot", "김재웅", "스프링 앱을 쉽게 개발 가능하게 해주는");
	}
	
	//GET - http://localhost:80/boardall
	@GetMapping("boardall")
	public List<Board> m4() {
		List<Board> all = new ArrayList<Board>();
		for (int i=0; i <10; i++) {
			all.add(new Board(i, "Spring Boot", "김재웅", "스프링 앱을 쉽게 개발 가능하게 해주는"));
		}
		return all;
	}
	
	//GET - http://localhost:80/board/{?}
	@GetMapping("boarduri/{id}")
	public String m5(@PathVariable String id) {
		return "안녕 " + id;
	}
	
}
