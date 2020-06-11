package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.PreselectionInformation;
import main.School;
import main.Student;

public class SchoolTest {

	@Test
	public void test1() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student[] students = new Student[] {st1};

		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		for (Student stu : students) {
			double scoreSum = stu.getChineseScore() * sc.getChineseWeights()
					+ stu.getEnglishScore() * sc.getEnglishWeights() + stu.getMathScore() * sc.getMathWeights()
					+ stu.getPhysicalScore() * sc.getPhysicalWeights()
					+ stu.getChemistryScore() * sc.getChemistryWeights();

			sc.addAndSortPreselection(stu, scoreSum);
		}
		
		sc.fillPreselection();
		List<PreselectionInformation> a = sc.getPreselection();
		
		assertEquals(1, sc.getPositiveFetchLen());
		assertEquals("正取1:01", a.get(0).getRank() + ":" + a.get(0).getStudentName());
	}
	
	@Test
	public void test2() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 10, 20, 30, 40, 50, "A", "B", "C");
		
		Student[] students = new Student[] {st1, st2};

		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		for (Student stu : students) {
			double scoreSum = stu.getChineseScore() * sc.getChineseWeights()
					+ stu.getEnglishScore() * sc.getEnglishWeights() + stu.getMathScore() * sc.getMathWeights()
					+ stu.getPhysicalScore() * sc.getPhysicalWeights()
					+ stu.getChemistryScore() * sc.getChemistryWeights();

			sc.addAndSortPreselection(stu, scoreSum);
		}

		sc.fillPreselection();
		List<PreselectionInformation> a = sc.getPreselection();

		assertEquals(2, sc.getPositiveFetchLen());
		assertEquals("正取1:02", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取1:01", a.get(1).getRank() + ":" + a.get(1).getStudentName());
	}
	
	@Test
	public void test3() throws Exception {
		Student st1 = new Student("01", 10, 20, 30, 40, 50, "A", "B", "C");
		Student st2 = new Student("02", 11, 20, 30, 40, 50, "A", "B", "C");
		Student st3 = new Student("03", 100, 20, 30, 40, 50, "A", "B", "C");

		Student[] students = new Student[] {st1, st2, st3};

		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		for (Student stu : students) {
			double scoreSum = stu.getChineseScore() * sc.getChineseWeights()
					+ stu.getEnglishScore() * sc.getEnglishWeights() + stu.getMathScore() * sc.getMathWeights()
					+ stu.getPhysicalScore() * sc.getPhysicalWeights()
					+ stu.getChemistryScore() * sc.getChemistryWeights();

			sc.addAndSortPreselection(stu, scoreSum);
		}

		sc.fillPreselection();
		List<PreselectionInformation> a = sc.getPreselection();

		assertEquals(3, sc.getPositiveFetchLen());
		
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

		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		for (Student stu : students) {
			double scoreSum = stu.getChineseScore() * sc.getChineseWeights()
					+ stu.getEnglishScore() * sc.getEnglishWeights() + stu.getMathScore() * sc.getMathWeights()
					+ stu.getPhysicalScore() * sc.getPhysicalWeights()
					+ stu.getChemistryScore() * sc.getChemistryWeights();

			sc.addAndSortPreselection(stu, scoreSum);
		}

		sc.fillPreselection();
		List<PreselectionInformation> a = sc.getPreselection();

		assertEquals(3, sc.getPositiveFetchLen());
		
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

		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		for (Student stu : students) {
			double scoreSum = stu.getChineseScore() * sc.getChineseWeights()
					+ stu.getEnglishScore() * sc.getEnglishWeights() + stu.getMathScore() * sc.getMathWeights()
					+ stu.getPhysicalScore() * sc.getPhysicalWeights()
					+ stu.getChemistryScore() * sc.getChemistryWeights();

			sc.addAndSortPreselection(stu, scoreSum);
		}

		sc.fillPreselection();
		List<PreselectionInformation> a = sc.getPreselection();

		assertEquals(3, sc.getPositiveFetchLen());

		assertEquals("正取1:04", a.get(0).getRank() + ":" + a.get(0).getStudentName());
		assertEquals("正取2:03", a.get(1).getRank() + ":" + a.get(1).getStudentName());
		assertEquals("正取3:01", a.get(2).getRank() + ":" + a.get(2).getStudentName());
		assertEquals("備取1:05", a.get(3).getRank() + ":" + a.get(3).getStudentName());
		assertEquals("備取1:02", a.get(3).getRank() + ":" + a.get(4).getStudentName());
	}
	
	@Test
	public void test6() throws Exception {
		School sc = new School("A", 1.5, 1, 1, 1, 0.5);
		assertEquals("A", sc.getSchoolName());
	}
	
	@Test(expected=Exception.class)
	public void test7() throws Exception {
		School sc = new School("A", 3, 1, 1, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test8() throws Exception {
		School sc = new School("A", -3, 1, 1, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test9() throws Exception {
		School sc = new School("A", 1, 3, 1, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test10() throws Exception {
		School sc = new School("A", 1, -3, 1, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test11() throws Exception {
		School sc = new School("A", 1, 1, 3, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test12() throws Exception {
		School sc = new School("A", 1, 1, -3, 1, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test13() throws Exception {
		School sc = new School("A", 1, 1, 1, 3, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test14() throws Exception {
		School sc = new School("A", 1, 1, 1, -3, 0.5);
	}
	
	@Test(expected=Exception.class)
	public void test15() throws Exception {
		School sc = new School("A", 1, 1, 1, 1, 3);
	}
	
	@Test(expected=Exception.class)
	public void test16() throws Exception {
		School sc = new School("A", 1, 1, 1, 1, -3);
	}
	

}
