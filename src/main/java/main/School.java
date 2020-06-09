package main;
import java.util.ArrayList;

public class School {
  private String schoolName;
  private double chineseWeights = 0.0;
  private double englishWeights = 0.0;
  private double mathWeights = 0.0;
  private double physicalWeights = 0.0;
  private double chemistryWeights = 0.0;
  private ArrayList<PreselectionInformation> preselection = 
          new ArrayList<PreselectionInformation>();
  private ArrayList<Student> studentData = new ArrayList<Student>();
  //正取人數
  private int positiveFetchLen = 0;
  
  /**
   * 建構School.
   * @param schoolName 學校名稱(String)
   * @param chineseWeights 國文權重(double)，介於0~2
   * @param englishWeights 英文權重(double)，介於0~2
   * @param mathWeights 數學權重(double)，介於0~2
   * @param physicalWeights 物理權重(double)，介於0~2
   * @param chemistryWeights 化學權重(double)，介於0~2
   * @throws Exception 有權重 > 2 or < 0
   */
  public School(
          String schoolName,
          double chineseWeights,double englishWeights,double mathWeights,
          double physicalWeights,double chemistryWeights) throws MyException {
    this.schoolName = schoolName;
      
    if ((chineseWeights < 0) || (chineseWeights > 2)) {
      throw new MyException(schoolName + "ChineseWeights error");
    }
    this.chineseWeights = chineseWeights;
      
    if ((englishWeights < 0) || (englishWeights > 2)) {
      throw new MyException(schoolName + "englishWeights error");
    }
    this.englishWeights = englishWeights;
      
    if ((mathWeights < 0) || (mathWeights > 2)) {
      throw new MyException(schoolName + "mathWeights error");
    }
    this.mathWeights = mathWeights;
      
    if ((physicalWeights < 0) || (physicalWeights > 2)) {
      throw new MyException(schoolName + "physicalWeights error");
    }
    this.physicalWeights = physicalWeights;
      
    if ((chemistryWeights < 0) || (chemistryWeights > 2)) {
      throw new MyException(schoolName + "chemistryWeights error");
    }
    this.chemistryWeights = chemistryWeights;
  }
  
  public String getSchoolName() {
    return this.schoolName;
  }
  
  public double getChineseWeights() {
    return this.chineseWeights;
  }
  
  public  double getEnglishWeights() {
    return this.englishWeights;
  }
  
  public  double getMathWeights() {
    return this.mathWeights;
  }
  
  public double getPhysicalWeights() {
    return this.physicalWeights;
  }
  
  public double getChemistryWeights() {
    return this.chemistryWeights;
  }
  
  public ArrayList<PreselectionInformation> getPreselection() {
    return this.preselection;
  }
  
  public int getPositiveFetchLen() {
    return this.positiveFetchLen;
  }
  
  /**
   * 將有填此學校的學生加入，並依照總分進行邊插入邊排序填入.
   * @param student 學生物件
   * @param scoreSum 計算完的總分
   */
  public void addAndSortPreselection(Student student,double scoreSum) {
    if (this.preselection.isEmpty()) {
      this.preselection.add(new PreselectionInformation(student.getStudentName(),scoreSum));
      this.studentData.add(student);
    } else {
      //判斷是否是最後一個(當前最小的)
      boolean isLastSmall = false;
          
      for (int i = 0;i < this.preselection.size();i++) {
        if (this.preselection.get(i).getScoreSum() <= scoreSum) {
          this.preselection.add(i,new PreselectionInformation(student.getStudentName(),scoreSum));
          this.studentData.add(i,student);
          break;
        } else if (i == this.preselection.size() - 1) {
          //大家都比它大(所以他是最小的)
          isLastSmall = true;
        }
      }
          
      if (isLastSmall) {
        this.preselection.add(new PreselectionInformation(student.getStudentName(),scoreSum));
        this.studentData.add(student);
      }
    }
  }
  
  /**
   * 依照名單填入正備取.
   */
  public void fillPreselection() {
    //每所學校正取設定為3人
    int maxPositiveFetch = 3;
    int positiveFetchRank = 1;
    //正取排名
    for (int i = 0;i < this.preselection.size();i++) {
      //第一名
      if (this.positiveFetchLen == 0) {
        String temp = "正取" +  Integer.toString(positiveFetchRank);
        this.preselection.get(i).setRank(temp);
        this.studentData.get(i).setResult(this.schoolName + ":" + temp);
        this.positiveFetchLen = this.positiveFetchLen + 1;
      } else if (this.preselection.get(i).getScoreSum() 
              == this.preselection.get(i - 1).getScoreSum()) {
        String temp = "正取" +  Integer.toString(positiveFetchRank);
        this.preselection.get(i).setRank(temp);
        this.studentData.get(i).setResult(this.schoolName + ":" + temp);
        this.positiveFetchLen = this.positiveFetchLen + 1;
      } else if (positiveFetchLen < maxPositiveFetch) {
        positiveFetchRank = positiveFetchRank + 1;
        String temp = "正取" +  Integer.toString(positiveFetchRank);
        this.preselection.get(i).setRank(temp);
        this.studentData.get(i).setResult(this.schoolName + ":" + temp);
        this.positiveFetchLen = this.positiveFetchLen + 1;
      } else {
        break;
      }
    }
      
    //確定還有人可以進行備取
    if (this.positiveFetchLen < this.preselection.size()) {
      int waitingRank = 0;
      //備取排名
      for (int i = this.positiveFetchLen;i < this.preselection.size();i++) {
        if (this.preselection.get(i).getScoreSum() == this.preselection.get(i - 1).getScoreSum()) {
          String temp = "備取" +  Integer.toString(waitingRank);
          this.preselection.get(i).setRank(temp);
          this.studentData.get(i).setResult(this.schoolName + ":" + temp);
        } else {
          waitingRank = waitingRank + 1;
          String temp = "備取" +  Integer.toString(waitingRank);
          this.preselection.get(i).setRank(temp);
          this.studentData.get(i).setResult(this.schoolName + ":" + temp);
        }
      } 
    }
  }
}