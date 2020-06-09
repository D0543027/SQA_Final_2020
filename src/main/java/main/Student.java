package main;

public class Student {
  private String studentName;
  private int chinese = 0;
  private int english = 0;
  private int math = 0;
  private int physical = 0;
  private int chemistry = 0;
  private String[] voluntaryOrder = new String[3];
  private String[] result = new String[3];
  
  /**
   * 建構Student.
   * @param studentName 學生名稱(string)
   * @param chinese 國文分數(int)，介於0～100分
   * @param english 英文分數(int)，介於0～100分
   * @param math 數學分數(int)，介於0～100分
   * @param physical 物理分數(int)，介於0～100分
   * @param chemistry 化學分數(int)，介於0～100分
   * @param order1 志願序1
   * @param order2 志願序2
   * @param order3 志願序3
   * @throws Exception 有分數 > 100 or < 0
   */
  public Student(
      String studentName,
      int chinese,int english,int math,int physical,int chemistry,
      String order1,String order2,String order3)  throws MyException {
    this.studentName = studentName;
        
    if ((chinese < 0) || (chinese > 100)) {
      throw new MyException(studentName + "Chinese score error");
    }
    this.chinese = chinese;
        
    if ((english < 0) || (english > 100)) {
      throw new MyException(studentName + "English score error");
    }
    this.english = english;
        
    if ((math < 0) || (math > 100)) {
      throw new MyException(studentName + "Math score error");
    }
    this.math = math;
        
    if ((physical < 0) || (physical > 100)) {
      throw new MyException(studentName + "Physical score error");
    }
    this.physical = physical;
        
    if ((chemistry < 0) || (chemistry > 100)) {
      throw new MyException(studentName + "Chemistry score error");
    }
    this.chemistry = chemistry;
        
    this.voluntaryOrder[0] = order1;
    this.voluntaryOrder[1] = order2;
    this.voluntaryOrder[2] = order3;
  }
    
  public String getStudentName() {
    return this.studentName;
  }
    
  public int getChineseScore() {
    return this.chinese;
  }
    
  public int getEnglishScore() {
    return this.english;
  }
    
  public int getMathScore() {
    return this.math;
  }
    
  public int getPhysicalScore() {
    return this.physical;
  }
    
  public int getChemistryScore() {
    return this.chemistry;
  }
    
  public String[] getVoluntaryOrder() {
    return this.voluntaryOrder;
  }
    
  /**
   * 將回傳的正備取名次填入相對位置.
   * @param rank 學校名稱+正備取名次(String)，example A:正取1
   */
  public void setResult(String rank) {
    String[] temp = rank.split(":");
    for (int i = 0;i < this.voluntaryOrder.length;i++) {
      if (temp[0].equalsIgnoreCase(this.voluntaryOrder[i])) {
        this.result[i] = rank;
      }else {
    	  //do Nothing
      }
    }
  }
    
  public String[] getRank() {
    return this.result;
  }
}
