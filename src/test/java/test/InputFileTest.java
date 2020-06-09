package test;
import static org.junit.Assert.*;

import org.junit.Test;

import main.InputFile;

public class InputFileTest {

	@Test(expected=Exception.class)
	public void test1() throws Exception{
		String path = null;
		InputFile inputFile = new InputFile();
		inputFile.readSchoolFile(path);
	}
	
	@Test(expected=Exception.class)
	public void test2() throws Exception{
		String path = null;
		InputFile inputFile = new InputFile();
		inputFile.readStudentFile(path);
	}

	@Test()
	public void test3() throws Exception{
		String path = "./input/school_input.csv";
		InputFile inputFile = new InputFile();
		inputFile.readSchoolFile(path);
		assertTrue(true);
	}
	
	@Test()
	public void test4() throws Exception{
		String path = "./input/student_input.csv";
		InputFile inputFile = new InputFile();
		inputFile.readStudentFile(path);
		assertTrue(true);
	}
}