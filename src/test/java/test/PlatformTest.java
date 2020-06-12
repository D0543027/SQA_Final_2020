package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.MyException;
import main.Platform;
import main.PreselectionInformation;
import main.School;
import main.Student;

public class PlatformTest {
	@Test
	public void test1() throws Exception {
		Student st1 = new Student("01", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student[] students = new Student[] {st1};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School sch4 = new School("D", 1, 2, 2 ,1, 0);
		School[] schools = new School[] {sch1, sch2, sch3};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> p4 = sch4.getPreselection();
		assertEquals(0, sch4.getPositiveFetchLen());
	}
	
	@Test
	public void test2() throws Exception {
		Student st1 = new Student("01", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student st2 = new Student("02", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		
		Student[] students = new Student[] {st1, st2};


		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(2, sch1.getPositiveFetchLen());
		assertEquals("正取1:02", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取1:01", a.get(1).getRank() + ":" + a.get(1).getStudentName());
	}
	
	@Test
	public void test3() throws Exception {
		Student st1 = new Student("01", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student st2 = new Student("02", new int[] {11, 20, 30, 40, 50}, "A", "B", "C");
		Student st3 = new Student("03", new int[] {100, 20, 30, 40, 50}, "A", "B", "C");

		Student[] students = new Student[] {st1, st2, st3};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(3, sch1.getPositiveFetchLen());
		
		assertEquals("正取1:03", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:02", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
	}
	
	@Test
	public void test4() throws Exception {
		Student st1 = new Student("01", new int[] {11, 20, 30, 40, 50}, "A", "B", "C");
		Student st2 = new Student("02", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student st3 = new Student("03", new int[] {100, 20, 30, 40, 50}, "A", "B", "C");
		Student st4 = new Student("04", new int[] {100, 100, 30, 40, 50}, "A", "B", "C");
		
		Student[] students = new Student[] {st1, st2, st3, st4};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(3, sch1.getPositiveFetchLen());
		
		assertEquals("正取1:04", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:03", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
		assertEquals("備取1:02", a.get(3).getRank() + ":" + a.get(3).getStudentName());
	}
	
	@Test
	public void test5() throws Exception {
		Student st1 = new Student("01", new int[] {11, 20, 30, 40, 50}, "A", "B", "C");
		Student st2 = new Student("02", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student st3 = new Student("03", new int[] {100, 20, 30, 40, 50}, "A", "B", "C");
		Student st4 = new Student("04", new int[] {100, 100, 30, 40, 50}, "A", "B", "C");
		Student st5 = new Student("05", new int[] {10, 20, 30, 40, 50}, "A", "B", "C");
		Student[] students = new Student[] {st1, st2, st3, st4, st5};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch3.getPreselection();

		assertEquals(3, sch3.getPositiveFetchLen());

		assertEquals("正取1:04", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:03", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
		assertEquals("備取1:05", a.get(3).getRank() + ":" + a.get(3).getStudentName());
		assertEquals("備取1:02", a.get(3).getRank() + ":" + a.get(4).getStudentName());
	}
	
	@Test(expected=MyException.class)
	public void test6() throws Exception {
		Student st1 = new Student("01", new int[] {11, 20, 30, 40, 50}, "A", "B", "C");
		Student[] students = new Student[] {st1};
		
		School sch1 = new School("D", 2, 1, 1, 1, 0);
		School[] schools = new School[] {sch1};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
	}
	
	@Test
	public void test7() throws Exception{
		Student st1 = new Student("01", new int[] {11, 20, 30, 40, 50}, "", "", "");
		Student[] students = new Student[] {st1};

		School sch1 = new School("A", 2, 1, 1, 1, 0);
		School[] schools = new School[] {sch1};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch1.getPreselection();
		assertEquals(0, sch1.getPositiveFetchLen());
	}
	
	@Test
	public void test8() throws Exception{
		Student st1 = new Student("01", new int[] {11, 20, 30, 40, 50}, "C", "", "");
		Student[] students = new Student[] {st1};

		School sch1 = new School("C", 2, 1, 1, 1, 0);
		School[] schools = new School[] {sch1};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		List<PreselectionInformation> a = sch1.getPreselection();
		assertEquals(1, sch1.getPositiveFetchLen());
		
		assertEquals("正取1:01", a.get(0).getRank() + ":" + a.get(0).getStudentName());
	}

}
