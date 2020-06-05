import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void test1() throws Exception {
		Student s = new Student("01", 10, 20, 40, 50, 60, "D", "E", "F");
		
		assertEquals("01", s.getStudentName());
		
		assertEquals(10, s.getChineseScore());
		assertEquals(20, s.getEnglishScore());
		assertEquals(40, s.getMathScore());
		assertEquals(50, s.getPhysicalScore());
		assertEquals(60, s.getChemistryScore());
		
		assertArrayEquals(new String[] {"D", "E", "F"} ,s.getVoluntaryOrder());
	}
	
	@Test(expected=Exception.class)
	public void test2() throws Exception {
		Student s = new Student("01", -1, 20, 40, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test3() throws Exception {
		Student s = new Student("01", 101, 20, 40, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test4() throws Exception {
		Student s = new Student("01", 10, -20, 40, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test5() throws Exception {
		Student s = new Student("01", 10, 200, 40, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test6() throws Exception {
		Student s = new Student("01", 10, 20, -40, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test7() throws Exception {
		Student s = new Student("01", 10, 20, 400, 50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test8() throws Exception {
		Student s = new Student("01", 10, 20, 40, -50, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test9() throws Exception {
		Student s = new Student("01", 10, 20, 40, 500, 60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test10() throws Exception {
		Student s = new Student("01", 10, 20, 40, 50, -60, "A", "B", "C");
	}
	
	@Test(expected=Exception.class)
	public void test11() throws Exception {
		Student s = new Student("01", 10, 20, 40, 50, 600, "A", "B", "C");
	}
}
