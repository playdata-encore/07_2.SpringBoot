package running;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.domain.Person;

public class SyntaxStream {
	@Test
	public void m1() {
		int [] values = {1,2,3,4,5};
		//모든 데이터 합 출력
		System.out.println(Arrays.stream(values).sum());
		
		//양수에 한해서만 합을 구해서 출력
		System.out.println(Arrays.stream(values).filter(v -> v%2 == 0).sum());
		
		
		Person p1 = new Person("김재웅", 20);
		Person p2 = new Person("김재", 30);
		Person p3 = new Person("김", 20);
		
		//다수의 데이터를 API를 통해서 List 객체로 생성
		List<Person> list = Arrays.asList(p1, p2, p3);
		list.stream().filter(v -> v.getAge() == 20).forEach(v -> System.out.println(v));
//		System.out.println(list.stream().filter(v -> v.getAge() == 20).forEach(v -> System.out.println(v)));
		
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "현주엽");
		map.put("2", "신동엽");
		map.put("3", "유재석");
		map.put("4", "이영자");
		map.put("5", "정찬우");
		map.put("6", "김태균");
		
		map.entrySet().stream().forEach(v->System.out.println(v));
		map.entrySet().stream().forEach(v->System.out.println(v.getKey() + v.getValue()));
		map.entrySet().stream().filter(v -> v.getKey()=="1").forEach(v->System.out.println(v.getKey() + v.getValue()));
		map.keySet().stream().forEach(v->System.out.println(v));
		map.values().stream().forEach(v->System.out.println(v));
		
	}
}
