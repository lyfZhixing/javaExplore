package lyf.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringTest {

	private long startTime ;
	private long endTime ;
	
	@Before
	public void start(){
		startTime = System.currentTimeMillis();
	}
	@After
	public void end(){
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
	@Test
	public void stringTest() {
		String s1 = "abc";
		s1 = "abc"+"1";			//此处的s1和上边上的s1不是同一个对象
		
		
	}
	
	@Test
	public void stringBufferTest(){
		StringBuffer s1 = new StringBuffer("abc");
		s1.append("1");
	}
	
	@Test
	public void stringBuildTest(){
		StringBuilder s1 = new StringBuilder("abc");
		s1.append("1");
	}

}
