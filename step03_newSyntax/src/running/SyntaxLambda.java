package running;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.domain.Person;

public class SyntaxLambda {
	@Test
	public void m1() {
		Person p1 = new Person("김재웅", 20);
		Person p2 = new Person("김재", 20);
		Person p3 = new Person("김", 20);
		
		//다수의 데이터를 API를 통해서 List 객체로 생성
		List<Person> list = Arrays.asList(p1, p2, p3);
		
		//step01 - 기본
		for(Person p : list) {
			System.out.println(p);
		}
		
		//step02 : lambda
		//메소드 구현부로 정의하지 않고 하나의 식처럼 표현하는 문법(표현식)
		System.out.println("--step02 : 표현식이라는 lambda");
		list.forEach(p->System.out.println(p));
		
		//step03 : lambda & double colon
		//메소드 구현부로 정의하지 않고 하나의 식처럼 표현하는 문법(표현식)
		System.out.println("--step03 : 표현식이라는 lambda & colon 문법");
		list.forEach(System.out::println);
		
		//step04 : lambda + 연산
		//출력 결과에 사칙연산
		int i = 10;
		Arrays.asList(1,2,3).forEach(v -> System.out.println(v + i));
	}
	
	@Test //step05 : map 계열 forEach 활용방법
	public void m2() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "현주엽");
		map.put("2", "신동엽");
		map.put("3", "유재석");
		map.put("4", "이영자");
		map.put("5", "정찬우");
		map.put("6", "김태균");
		
		map.forEach((k,v) -> System.out.println(k + " - " + v));
		
		map.entrySet().stream().forEach(v->System.out.println(v));
	}
}
