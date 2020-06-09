package main;

public class PreselectionInformation {
  private String studentName;
  private double scoreSum;
  private String rank;
      
  public PreselectionInformation(String studentName,double scoreSum) {
    this.studentName = studentName;
    this.scoreSum = scoreSum;
  }
      
  public String getStudentName() {
    return this.studentName;
  }
      
  public double getScoreSum() {
    return this.scoreSum;
  }
      
  public String getRank() {
    return this.rank;
  }
      
  public void setRank(String rank) {
    this.rank = rank;
  }
}
