package flex;
import java.util.*;

public class Student extends Person {

    public Student() {
    }
    public String rollNo;

    public String batch;

    public Degree dept;

    public List<Registration> totalSemesters;

    public float cgpa;

    public int creditHoursAttempted;

    public int creditHoursObtained;

    public String currentSemester;

    public List<FeeChallan> feeRecord;

    public void print() {
    }

    public void printTranscript() {
    }

    public float getCgpa() {
        return 0.0f;
    }

    public void setCgpa() {
    }

    public void addCourse() {
    }

    public void checkPreReq() {
    }

    public void setAttendance(Registration r) {
    }

    public void calculateFee() {
    }

    public void dropCourse() {
    }

    public void displayFee() {
    }

    public void printRegisteredCourses() {
    }
    
    public float calculategpa(List<Course> clist) {
        float gpa = 0;
        int totalcredit = 0;
        double tpoint = 0;
        try {

            System.err.println(clist.size());
            for (int g = 0; g < clist.size(); g++) {
                int credit = Integer.parseInt(clist.get(g).creditHours);
                String grade = (clist.get(g).grade);
                System.err.println(grade);
                double point = 0;
                if (grade.equals("A+")) {
                    point = credit * 4;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("A")) {
                    point = credit * 4;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("A-")) {
                    point = credit * 3.67;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("B+")) {
                    point = credit * 3.3;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("B")) {
                    point = credit * 3;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("B-")) {
                    point = credit * 2.67;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("C+")) {
                    point = credit * 2.33;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("C")) {
                    point = credit * 2;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("C-")) {
                    point = credit * 1.67;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("D+")) {
                    point = credit * 1.33;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("D")) {
                    point = credit * 1;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                } else if (grade.equals("F")) {
                    point = credit * 0;
                    totalcredit = totalcredit + credit;
                    tpoint = tpoint + point;

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        gpa = (float) (tpoint / totalcredit);
        return gpa;

    }

}
