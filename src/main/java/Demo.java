
public class Demo {
  /**
   * main.
   * @param args 無
   * @throws Exception 讀檔失敗
   */
  public static void main(String[] args) throws Exception {
    /*
    Student s1 = new Student("01",10,20,30,40,50,"A","B","C");
    Student s2 = new Student("02",20,30,40,50,60,"A","B","C");
    Student s3 = new Student("03",30,40,50,60,70,"B","A","D");
    Student s4 = new Student("04",40,50,60,70,80,"C","A","B");
    Student s5 = new Student("05",50,60,70,80,90,"A","D","B");
    Student s6 = new Student("06",90,80,70,60,50,"A","B","C");
    Student s7 = new Student("07",80,70,60,50,40,"A","B","C");
    Student s8 = new Student("08",50,30,90,90,20,"A","B","C");
    Student s9 = new Student("09",40,70,10,30,60,"A","B","C");
    Student[] students = {s1, s2, s3, s4, s5, s6 ,s7, s8, s9};
    */
    /*
    School[] schools = {new School("A",1,1,1,1,1),
            new School("B",0,1,2,2,0),
            new School("C",1.5,2,2,0,0),
            new School("D",1,1.25,1.5,1.25,1),
            new School("E",2,1,1.5,1.75,0),
            new School("F",2,1,0,2,0)};
    */
    //讀檔
    InputFile input = new InputFile();
    String schoolPath = "./input/school_input.csv";
    String studentsPath = "./input/student_input.csv";
    School[] schools =  input.readSchoolFile(schoolPath);
    Student[] students = input.readStudentFile(studentsPath);
    System.out.print("--------------------開始讀檔--------------------\n");
    Platform plf = new Platform(students, schools);
    System.out.print("--------------------檔案讀取完畢-----------------\n");
    //將學生的志願序學校依序放入學生與加權完的成績
    plf.countScore();
    plf.fillFetch();
    System.out.print("--------------------開始輸出--------------------\n");
    //輸出
    plf.outputSchoolPreselection();
    plf.outputStudentRank();
    System.out.print("--------------------輸出完畢--------------------\n");
    System.out.print("--------------------檔案在output資料夾下---------\n");
  }
  
}
