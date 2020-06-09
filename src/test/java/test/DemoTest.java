package test;
import static org.junit.Assert.*;

import org.junit.Test;

import main.Demo;

public class DemoTest {

	@Test
	public void test() throws Exception {
		Demo d = new Demo();
		d.main(null);
		
		assertTrue(true);
		
	}

}
