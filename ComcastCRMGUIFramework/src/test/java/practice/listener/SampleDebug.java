package practice.listener;

import org.testng.annotations.Test;

public class SampleDebug extends SampleDebug2{
	@Test
	public void test() {
		System.out.println("s1");
		System.out.println("s2");
	   int s=  demo(5,6);
		//System.out.println(demo(5,6));
	   System.out.println(s);
	   System.out.println("after bp");
	   System.out.println("close");
	}
	
	

}
