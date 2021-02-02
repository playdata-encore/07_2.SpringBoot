package running;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class SyntaxOptional {
	//NullPointerExcetion의 Optional 을 통한 처리 방법
	//@Test
	public void m1() {
		String v = null;
		int length = v.length(); //null.length();
		System.out.println("문자열 길이 " + length);
	}
	
//	@Test
	public void m2() {
		String v = null;
		
		if(v != null) {
			int length = v.length(); //null.length();
			System.out.println("문자열 길이 " + length);
		}
	}
	
	/* ofNullable()
	 * - Optional 컨테이너가 보유하게 되는 객체가 null일수도 실제 객체일수도 있는 메소드
	 * - ifPresent() 로 조건 검증 해서 실행여부 결정 권장
	 */
//	@Test
	public void m3() {
		String v = null;
		String v2 = "playdata";
		
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt);
		System.out.println(opt.isPresent());
		
		//null포인터를 띄우는게 아니라 실행 자체를 안하기 때문에 안정적인 코드가 된다.
		opt.ifPresent(data -> {
			System.out.println("길이 : " + data.length());
		});
		
		Optional<String> opt2 = Optional.ofNullable(v2);
		System.out.println(opt2);
		System.out.println(opt2.isPresent());
		
		opt2.ifPresent(data -> {
			System.out.println("길이 : " + data.length());
		});
		
	}
	
	/* of() : 절대 null 허용하지 않는 메소드
	 * 만일 null인 경우 nullpointerexception 발생
	 */
//	@Test
	public void m4() {
		String v = null;
		String v2 = "playdata";
		
//		Optional<String> opt = Optional.of(v); //  nullpointerexception 발생. 따라서 다음 로직 실행 불가
//		System.out.println(opt);

		Optional<String> opt2 = Optional.of(v2);
		System.out.println(opt2); //Optional[playdata]
	}
	
	@Test
	public void m5() {
		String v = null;
//		String v = "1123";
		
		if (v != null) {
			int length = v.length();
			System.out.println(length);
		} else {
			System.out.println("null이야");
		}
		
		Optional<String> opt = Optional.ofNullable(v);
		
//		opt.ifPresent(data->System.out.println(data.length()));
		System.out.println(opt.map(String::length).orElse(null));
//		System.out.println(opt.orElse("null이야"));
	}
}
