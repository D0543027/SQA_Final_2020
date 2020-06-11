package main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Platform {
	private Student[] std;
	private School[] sch;
	private List<String> schNameList = new ArrayList();

	/**
	 * 建構Platform.
	 * 
	 * @param students 所有學生
	 * @param schools  所有學校
	 * @throws Exception
	 */
	public Platform(Student[] students, School[] schools) throws MyException {
		this.std = students;
		this.sch = schools;

		for (int i = 0; i < schools.length; i++) {
			schNameList.add(schools[i].getSchoolName());
		}

		// ************************************************
		// 0609 檢查志願序
		// ************************************************
		for (Student stu : students) {
			String[] voluntary = stu.getVoluntaryOrder();
			for (String s : voluntary) {
				if (!schNameList.contains(s) && !s.isEmpty()) {
					throw new MyException("志願序不存在");
				}
			}
		}
	}

	/**
	 * 計算每位學生加權完的成績. 並放入該學校的preselection
	 */
	public void countScore() {
		for (Student students : std) {
			String[] voluntaryOrder = students.getVoluntaryOrder();
			
			for (int i = 0; i < voluntaryOrder.length; i++) {
				if (!voluntaryOrder[i].isEmpty()) {
					int index = schNameList.indexOf(voluntaryOrder[i]);

					double scoreSum = students.getChineseScore() * sch[index].getChineseWeights()
							+ students.getEnglishScore() * sch[index].getEnglishWeights()
							+ students.getMathScore() * sch[index].getMathWeights()
							+ students.getPhysicalScore() * sch[index].getPhysicalWeights()
							+ students.getChemistryScore() * sch[index].getChemistryWeights();
					
					sch[index].addAndSortPreselection(students, scoreSum);
				}
			}
		}
	}

	/**
	 * 每所學校依照名單填入正備取.
	 */
	public void fillFetch() {
		for (School schools : sch) {
			schools.fillPreselection();
		}
	}

	/**
	 * 將School preselection輸出成school_output.txt
	 */
	public void outputSchoolPreselection() throws IOException {
		File writeName = new File("./output/school_output.txt");
		List<PreselectionInformation> preselection = new ArrayList();

		try (FileWriter fwriter = new FileWriter(writeName)) {
			for (School schools : sch) {
				preselection = schools.getPreselection();

				fwriter.write(schools.getSchoolName() + "\n");
				// 輸出正取
				for (int i = 0; i < schools.getPositiveFetchLen(); i++) {
					fwriter.write(preselection.get(i).getRank() + ":" + preselection.get(i).getStudentName() + "  ");
				}
				fwriter.write("\n");
				// 如果還有備取(則輸出備取)
				if (schools.getPositiveFetchLen() < preselection.size()) {
					for (int i = schools.getPositiveFetchLen(); i < preselection.size(); i++) {
						fwriter.write(
								preselection.get(i).getRank() + ":" + preselection.get(i).getStudentName() + "  ");
					}
					fwriter.write("\n");
				}
				fwriter.write("----------------------------------------------------------------------\n");
			}
		}
	}

	/**
	 * 將Student result輸出成student_output.txt
	 */
	public void outputStudentRank() throws IOException {
		File writeName = new File("./output/student_output.txt");
		try (FileWriter fwriter = new FileWriter(writeName)) {
			for (Student students : std) {
				fwriter.write(students.getStudentName() + "\n");
				for (int i = 0; i < students.getRank().length; i++) {
					fwriter.write(students.getRank()[i] + "  ");
				}
				fwriter.write("\n");
				fwriter.write("----------------------------------------------------------------------\n");
			}
		}
	}
}
