package step02.assertion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssertionTest {
	// parameter가 하나 이상인 상황에서의 단위테스트
//	@ParameterizedTest
//	@CsvSource({"1,t1","2,t2"})
//	public void m4(int i, String s) {
//		System.out.println("m4 " + i + " - " + s);
//	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/test.csv")
	public void m5(String c1, int c2, int c3, int c4, int c5, int c6, int c7) {
		System.out.println(c1 + c2);
	}
	
	
	
	//parameter 있는 메소드 처리
	/* @Test 불필요
	 * test하고자 하는 데이터 수만큼 메소드 자동 호출
	 */
//	@ParameterizedTest
	@ValueSource(ints= {1,2,3,4,5})
	public void m3(int i) {
		//? parameter 값이 4미만인 데이터값들만 출력 해야만 하는 상황
		assertTrue(i < 4);
		System.out.println("m3() " + i);
	}
	
	//null값 검증 단정문 test
//	@Test
	public void m2() {
//		assertNotNull(null);
		assertNull(null);
		System.out.println("biz1");
	}
	
//	@Test
	public void m1() {
		System.out.println("m1");
		assertNotEquals("junit", "Junit"); //pass
		System.out.println("biz logic 1");
		
//		assertNotEquals("junit", "junit"); //non pass 따라서 다음 로직 실행 불가
//		System.out.println("biz logic 2");
		
		//--------------------------------------------------------------

		assertEquals("A", new String("A")); //pass 이건 100% 일치되는 단일 객체가 아니어도 값이 동일한 경우 path
		
		//--------------------------------------------------------------
		assertSame("junit", "junit"); //pass
		System.out.println("biz logic 3");
		
//		assertSame("A", "a"); //non pass 따라서 다음 로직 실행 불가
//		assertSame("A", new String("A")); // 데이터 타입과 값이 100% 일치될 경우에만 pass(true)
		System.out.println("biz logic 4");
	}
}
