package step01.unittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTestLifeCycle {
	
	@BeforeAll // 비포 올은 스태틱이어야 함. 그렇치 사실
	public static void beforeAll() { 
		System.out.println("beforeAll");
	}
	
	@BeforeEach // Test 전에 실행되는 애노테이션 - 전처리
	public void m2() { 
		System.out.println("m2");
	}
	
	@Test
	public void m1() { //static은 실행 안됨!
		System.out.println("m1");
	}
	
	@DisplayName("m5 이름 지정")
	@Test
	public void m5() { //static은 실행 안됨!
		System.out.println("m5");
	}
	
	@AfterEach // Test 후에 실행되는 애노테이션 - 후처리
	public void m3() { 
		System.out.println("m3");
	}
	
	// before나 after는 JUNIT에 안나오네??
}
