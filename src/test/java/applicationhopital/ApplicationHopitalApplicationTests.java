package applicationhopital;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationHopitalApplicationTests {
	
	@BeforeAll
	static void setup(){
		System.out.println("@BeforeAll- se lance une fois");
	}
	
	@BeforeEach
	void init(){
		System.out.println("@BeforeEach- se lance a chaque test");
	}
	

	@Test
	void l() {
		System.out.println("voici le resuktat de mon test1");
	}
	
	@Test
	void testBeforeEach() {
		System.out.println("voici le resuktat de mon test2");
	}

}
