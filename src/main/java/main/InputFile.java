package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputFile {
	/**
	 * 讀取school_input.csv資料. csv資料格式為:學校,國文權重,英文權重,數學權重,物理權重,化學權重
	 * 型態：String,double,double,double,double,double
	 * 
	 * @return School[]
	 * @throws Exception csv不存在，或資料格式錯誤
	 */
	public School[] readSchoolFile(String path) throws Exception {
		ArrayList<School> arrayListSchools = new ArrayList<School>();
		// String path = "./input/school_input.csv";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
		try (BufferedReader reader = new BufferedReader(isr)) {
			String line = null;
			// 讀取標題
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");
				arrayListSchools.add(new School(item[0].trim(), Double.parseDouble(item[1].trim()),
						Double.parseDouble(item[2].trim()), Double.parseDouble(item[3].trim()),
						Double.parseDouble(item[4].trim()), Double.parseDouble(item[5].trim())));
			}
		}
		School[] schools = new School[arrayListSchools.size()];
		schools = arrayListSchools.toArray(schools);

		return schools;
	}

	/**
	 * 讀取student_input.csv資料. csv資料格式為:姓名,國文,英文,數學,物理,化學,志願序1,志願序2,志願序3
	 * 型態:String,int,int,int,int,int,String,String,String
	 * 
	 * @return Student[]
	 * @throws Exception csv不存在，或資料格式錯誤
	 */
	public Student[] readStudentFile(String path) throws Exception {
		ArrayList<Student> arrayListStudents = new ArrayList<Student>();
		// String path = "./input/student_input.csv";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
		try (BufferedReader reader = new BufferedReader(isr)) {
			String line = null;
			// 讀取標題
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");
				arrayListStudents.add(
						new Student(item[0].trim(), Integer.parseInt(item[1].trim()), Integer.parseInt(item[2].trim()),
								Integer.parseInt(item[3].trim()), Integer.parseInt(item[4].trim()),
								Integer.parseInt(item[5].trim()), item[6].trim(), item[7].trim(), item[8].trim()));
			}
		}
		Student[] students = new Student[arrayListStudents.size()];
		students = arrayListStudents.toArray(students);

		return students;
	}
}
