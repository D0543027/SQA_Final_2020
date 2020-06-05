import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlatformTest {

	@Test
	public void test1() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student[] students = new Student[] {st1};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School sch4 = new School("D", 1, 2, 2 ,1, 0);
		School[] schools = new School[] {sch1, sch2, sch3};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		ArrayList<PreselectionInformation> p4 = sch4.getPreselection();
		assertEquals(0, sch4.getPositiveFetchLen());
	}
	
	@Test
	public void test2() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 10, 20, 30, 40, 50, "A", "B", "C");
		
		Student[] students = new Student[] {st1, st2};


		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};
		
		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		ArrayList<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(2, sch1.getPositiveFetchLen());
		assertEquals("正取1:02", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取1:01", a.get(1).getRank() + ":" + a.get(1).getStudentName());
	}
	
	@Test
	public void test3() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 11, 20, 30, 40, 50, "A", "B", "C");
		Student st3 = new Student("03", 100, 20, 30, 40, 50, "A", "B", "C");

		Student[] students = new Student[] {st1, st2, st3};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		ArrayList<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(3, sch1.getPositiveFetchLen());
		
		assertEquals("正取1:03", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:02", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
	}
	
	@Test
	public void test4() throws Exception {
		Student st1 = new Student("01", 11, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st3 = new Student("03", 100, 20, 30, 40, 50, "A", "B", "C");
		Student st4 = new Student("04", 100, 100, 30, 40, 50, "A", "B", "C");
		
		Student[] students = new Student[] {st1, st2, st3, st4};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		ArrayList<PreselectionInformation> a = sch1.getPreselection();

		assertEquals(3, sch1.getPositiveFetchLen());
		
		assertEquals("正取1:04", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:03", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
		assertEquals("備取1:02", a.get(3).getRank() + ":" + a.get(3).getStudentName());
	}
	
	@Test
	public void test5() throws Exception {
		Student st1 = new Student("01", 11, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st3 = new Student("03", 100, 20, 30, 40, 50, "A", "B", "C");
		Student st4 = new Student("04", 100, 100, 30, 40, 50, "A", "B", "C");
		Student st5 = new Student("05", 10, 20, 30, 40, 50, "A", "B", "C");
		Student[] students = new Student[] {st1, st2, st3, st4, st5};

		School sch1 = new School("A", 1.5, 1, 1, 1, 0.5);
		School sch2 = new School("B", 2, 1, 1, 1, 1);
		School sch3 = new School("C", 1.5, 1, 2, 1, 1);
		School[] schools = new School[] {sch1, sch2, sch3};

		Platform pf = new Platform(students, schools);
		pf.countScore();
		pf.fillFetch();
		
		ArrayList<PreselectionInformation> a = sch3.getPreselection();

		assertEquals(3, sch3.getPositiveFetchLen());

		assertEquals("正取1:04", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:03", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
		assertEquals("備取1:05", a.get(3).getRank() + ":" + a.get(3).getStudentName());
		assertEquals("備取1:02", a.get(3).getRank() + ":" + a.get(4).getStudentName());
	}
	

}
