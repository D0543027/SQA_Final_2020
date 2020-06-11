package main;

import java.util.logging.Logger;

public class Demo {
	private static final Logger LOGGER = Logger.getLogger("Demo");
  /**
   * main.
   * @param args 無
   * @throws Exception 讀檔失敗
   */
  public static void main(String[] args) throws Exception {
   
    //讀檔
    InputFile input = new InputFile();
    String schoolPath = "./input/school_input.csv";
    String studentsPath = "./input/student_input.csv";
    School[] schools =  input.readSchoolFile(schoolPath);
    Student[] students = input.readStudentFile(studentsPath);
    LOGGER.info("--------------------開始讀檔--------------------\n");
    
    Platform plf = new Platform(students, schools);
    LOGGER.info("--------------------檔案讀取完畢-----------------\n");
    //將學生的志願序學校依序放入學生與加權完的成績
    plf.countScore();
    plf.fillFetch();
    LOGGER.info("--------------------開始輸出--------------------\n");
    //輸出
    plf.outputSchoolPreselection();
    plf.outputStudentRank();
    LOGGER.info("--------------------輸出完畢--------------------\n");
    LOGGER.info("--------------------檔案在output資料夾下---------\n");
  }
  
}
