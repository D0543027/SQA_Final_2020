import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Platform {
	public Student[] std;
	public School[] sch;
	public ArrayList<String> schNameList = new ArrayList<String>();

	/**
	 * 建構Platform.
	 * 
	 * @param students 所有學生
	 * @param schools  所有學校
	 */
	public Platform(Student[] students, School[] schools) {
		this.std = students;
		this.sch = schools;

		for (int i = 0; i < schools.length; i++) {
			schNameList.add(schools[i].getSchoolName());
		}
	}

	/**
	 * 計算每位學生加權完的成績. 並放入該學校的preselection
	 */
	public void countScore() {
		for (Student students : std) {
			String[] voluntaryOrder = students.getVoluntaryOrder();
			// System.out.println(students.getStudentName());
			for (int i = 0; i < voluntaryOrder.length; i++) {
				int index = schNameList.indexOf(voluntaryOrder[i]);
				// System.out.println(voluntaryOrder[i]);
				// System.out.println(index);
				double scoreSum = students.getChineseScore() * sch[index].getChineseWeights()
						+ students.getEnglishScore() * sch[index].getEnglishWeights()
						+ students.getMathScore() * sch[index].getMathWeights()
						+ students.getPhysicalScore() * sch[index].getPhysicalWeights()
						+ students.getChemistryScore() * sch[index].getChemistryWeights();
				// System.out.println(students.getStudentName() + ":" + scoreSum);
				sch[index].addAndSortPreselection(students, scoreSum);
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
		ArrayList<PreselectionInformation> preselection = new ArrayList<PreselectionInformation>();
		FileWriter fwriter = null;

		try {
			fwriter = new FileWriter(writeName);
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
		} finally {
			fwriter.close();
		}
	}

	/**
	 * 將Student result輸出成student_output.txt
	 */
	public void outputStudentRank() throws IOException {
		File writeName = new File("./output/student_output.txt");
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(writeName);
			for (Student students : std) {
				fwriter.write(students.getStudentName() + "\n");
				for (int i = 0; i < students.getRank().length; i++) {
					fwriter.write(students.getRank()[i] + "  ");
				}
				fwriter.write("\n");
				fwriter.write("----------------------------------------------------------------------\n");
			}
		} finally {
			fwriter.close();
		}
	}
}
