/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flex;

import com.sun.corba.se.impl.corba.CORBAObjectImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;

public class dbconnectivity {

    Connection con;
    Statement stmt;
    PreparedStatement pst;

    dbconnectivity() {
        try {
            String s = "jdbc:sqlserver://localhost:1433;databaseName=flex"; //[connectdb on Default schema]
            con = DriverManager.getConnection(s, "connectdb", "123");

            stmt = (Statement) con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    boolean checklogin(String id, String pass, String tablename) {
        try {

            ResultSet rs = stmt.executeQuery("select password from " + tablename + " where id = '" + id + "'");
            if (rs.next()) {

                if (rs.getString("password").equals(pass)) {
                    return true;
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    String getname(String id, String tablename) {
        try {
            ResultSet rs = stmt.executeQuery("select name from " + tablename + " where id = '" + id + "'");
            rs.next();
            String n = rs.getString("name");
            return n;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    String getbatch(String id, String tablename) {
        try {
            ResultSet rs = stmt.executeQuery("select batch from " + tablename + " where id = '" + id + "'");
            rs.next();
            String n = rs.getString("batch");
            return n;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    void add_marks(String name, String num, String weightage, String totalNum, String course, String sec, List<Evaluation> obtainedMarks) {

        try {
            for (int i = 0; i < obtainedMarks.size(); i++) {
                stmt.execute("Insert into evaluation values ('" + name + "','" + obtainedMarks.get(i).obtainedMarks + "','"
                        + totalNum + "','" + weightage + "','" + obtainedMarks.get(i).studentRollno + "','"
                        + course + "','" + sec + "','" + num + "')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void changepassword(String prev_pass, String new_pass, String id, String tablename) {
        try {
            ResultSet rs = stmt.executeQuery("select password from " + tablename + " where id = " + id);

            if (rs.next()) {

                if (rs.getString("password").equals(prev_pass)) {
                    String s = "UPDATE " + tablename + " SET password = '" + new_pass + "' WHERE id = " + id;
                    stmt.executeUpdate(s);
                    JOptionPane.showMessageDialog(null, "Change Succesful");

                } else {
                    JOptionPane.showMessageDialog(null, "Previous Password Incorrect");

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void getGrades(String id, List<Course> c) {
        try {
            ResultSet rs = stmt.executeQuery("select courseid,coursename,grade from registration where studentid='" + id + "'");

            int i = 0;
            while (rs.next()) {

                Course temp = new Course();
                temp.courseID = rs.getString("courseid");
                temp.courseName = rs.getString("coursename");
                temp.grade = rs.getString("grade");
                c.add(temp);

            }

            for (Course obj : c) {
                ResultSet rs1 = stmt.executeQuery("select credithours from courses where id=" + obj.courseID);
                while (rs1.next()) {
                    obj.creditHours = rs1.getString("credithours");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void getAttendance(String id, String coursename, List<Attendance> c) {
        try {
            ResultSet rs = stmt.executeQuery("select lecture_no,lecture_date,credit_hours,istakenclass from attendance where student_rollno='" + id + "' and course_name= '" + coursename + "'");

            while (rs.next()) {

                Attendance temp = new Attendance();
                temp.lectureNo = rs.getString("lecture_no");
                temp.currentDate = rs.getString("lecture_date");
                temp.creditHours = rs.getString("credit_hours");
                temp.status = rs.getString("istakenclass");
                c.add(temp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void getAttendanceByLecture(String id, String coursename, List<Attendance> c, String lecno) {
        try {
            ResultSet rs = stmt.executeQuery("select lecture_no,lecture_date,credit_hours,istakenclass from attendance where student_rollno='" + id + "' and course_name= '" + coursename + "' and lecture_no='" + lecno + "'");

            while (rs.next()) {

                Attendance temp = new Attendance();
                temp.lectureNo = rs.getString("lecture_no");
                temp.currentDate = rs.getString("lecture_date");
                temp.creditHours = rs.getString("credit_hours");
                temp.status = rs.getString("istakenclass");
                c.add(temp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void dropCourse(String coursename, String section) {
        try {
            stmt.execute("delete from registration where studentid='" + StudentGUI.id + "' and coursename= '" + coursename + "' and section = '" + section + "'");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String getid(String name) {
        try {
            ResultSet rs = stmt.executeQuery("select Distinct studentid from registration\n"
                    + "join student on student.id=registration.studentid\n"
                    + "where student.name = '" + name + "'");

            while (rs.next()) {
                return rs.getString("studentid");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    void addgrade(String grade, String coursename, String sem, String id) {
        try {
//            String id = getid()
            stmt.execute("update registration set grade ='" + grade + "' where studentid='" + id + "' and coursename = '" + coursename
                    + "' and semester = '" + sem + "'");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void AddStudent(JTextField[] temp) {
        try {
            int i = 0;
            String id = temp[i].getText();
            i++;
            String fname = temp[i].getText();
            i++;
            String lname = temp[i].getText();
            i++;
            String pass = temp[i].getText();
            i++;
            String add = temp[i].getText();
            i++;
            String phone = temp[i].getText();
            i++;
            String fathername = temp[i].getText();
            i++;
            String dob = temp[i].getText();
            i++;
            String batch = temp[i].getText();
            i++;
            String cratt = temp[i].getText();
            i++;
            String crobt = temp[i].getText();
            i++;
            String currsem = temp[i].getText();
            i++;
            stmt.execute("insert into student values ('" + id + "','" + fname + "','" + lname + "','" + pass + "','" + add + "','"
                    + phone + "','" + fathername + "','" + dob + "','" + batch + "','" + cratt + "','" + crobt + "','" + currsem + "')"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void AddCourse(JTextField[] temp) {
        try {
            int i = 0;
            String id = temp[i].getText();
            i++;
            String fname = temp[i].getText();
            i++;
            String lname = temp[i].getText();
            i++;
            String pass = temp[i].getText();
            i++;
            String add = temp[i].getText();
            i++;
            String phone = temp[i].getText();
            i++;
            String fathername = temp[i].getText();
            i++;
            String dob = temp[i].getText();
            i++;
            String batch = temp[i].getText();
            i++;
            String cratt = temp[i].getText();
            i++;
            String crobt = temp[i].getText();
            i++;
            stmt.execute("insert into courses values ('" + id + "','" + fname + "','" + lname + "','" + pass + "','" + add + "','"
                    + phone + "','" + fathername + "','" + dob + "','" + batch + "','" + cratt + "','" + crobt + "')"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void AddTeacher(JTextField[] temp) {
        try {
            int i = 0;
            String id = temp[i].getText();
            i++;
            String fname = temp[i].getText();
            i++;
            String pass = temp[i].getText();
            i++;

            stmt.execute("insert into teacher values ('" + id + "','" + fname + "','" + pass + "')"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void getFailedCourses(List<String> failed) {

        try {
            ResultSet rs = stmt.executeQuery("select courseid from registration where studentid='" + StudentGUI.id + "' and grade='F'");

            while (rs.next()) {
                failed.add(rs.getNString("courseid"));

            }
//
//            System.out.println("Failed Courses:");
//            for (int i = 0; i < failed.size(); i++) {
//                System.out.println(failed.get(i));
//            }
//
//            System.out.println("Failed finished");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void getOfferedCourses(List<Course> obj, String semNum, List<String> failed) {
        try {

            ResultSet rs = stmt.executeQuery("select Distinct id,name,pre_req,postreq from courses  where semester_num='" + semNum + "'");

            while (rs.next()) {

                Course temp = new Course();
                temp.courseID = rs.getString("id");
                temp.courseName = rs.getString("name");
                temp.preReq = rs.getString("pre_req");
                temp.postReq = rs.getString("postreq");
                obj.add(temp);
            }
            List<Course> failedcourses = new ArrayList<>();
            for (int i = 0; i < failed.size(); i++) {
                rs = stmt.executeQuery("select Distinct id,name,postreq from courses  where semester_num='" + semNum + "' and name='" + failed.get(i) + "'");
                while (rs.next()) {

                    Course temp = new Course();
                    temp.courseID = rs.getString("id");
                    temp.courseName = rs.getString("name");

                    temp.postReq = rs.getString("postreq");
                    failedcourses.add(temp);
                    if (obj.contains(temp) == false) {
                    } else {
                        obj.add(temp);
                    }

                }
            }
            for (int i = 0; i < failed.size(); i++) {
                rs = stmt.executeQuery("Select postreq from courses where id='" + failed.get(i) + "'");
                while (rs.next()) {
                    Course temp = new Course();
                    temp.postReq = rs.getString("postreq");
                    for (int j = 0; j < obj.size(); j++) {
                        if (obj.get(j).courseID.equals(temp.postReq)) {
                            System.out.println(obj.get(j).courseName);
                            obj.remove(j);

                        }
                    }
                }
            }

            for (int i = 0; i < obj.size(); i++) {
                for (int j = 0; j < failed.size(); j++) {
                    if (obj.get(i).preReq.equals(failed.get(j))) {

                        obj.remove(i);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Boolean checkPreReqClear(String id) {

        String[] arr = new String[10];
        String val = new String();
        try {
            ResultSet rs = stmt.executeQuery("select distinct courseid from registration where grade='F'");
            int i = 0;
            while (rs.next()) {
                arr[i] = rs.getString("courseid");
                i++;
            }

            rs = stmt.executeQuery("select distinct pre_req FROM courses WHERE id='" + id + "'");
            while (rs.next()) {
                val = rs.getString("pre_req");
            }
            for (String element : arr) {
                if (element == val) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    String getPreReq(String id) {

        try {
            ResultSet rs = stmt.executeQuery("select distinct courseid from registration where grade='F'");
            while (rs.next()) {
                return rs.getString("courseid");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    void getSections(Course obj, List<String> sections) {
        try {
            ResultSet rs = stmt.executeQuery("select section from courses where semester='" + Admin.currentSemester + "' and name = '" + obj.courseName + "'");
            while (rs.next()) {

                Course temp = new Course();
                temp.section = rs.getString("section");
                sections.add(temp.section);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String getSemesterNumber(String id) {
        String temp = "";
        try {
            ResultSet rs = stmt.executeQuery("select currentsemester from student where id='" + StudentGUI.id + "'");
            while (rs.next()) {
                temp = rs.getString("currentsemester");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }

    void getMarks(String id, String coursename, List<Evaluation> c) {
        try {
            ResultSet rs = stmt.executeQuery("select number,weightage,evaluation_type,marks_obt,marks_tot,number from evaluation where student_rollno='" + id + "'and course_name='" + coursename + "'order by weightage,evaluation_type");

            while (rs.next()) {

                Evaluation temp = new Evaluation();
                temp.weightage = rs.getString("weightage");
                temp.obtainedMarks = Float.valueOf(rs.getString("marks_obt"));
                temp.totalMarks = rs.getString("marks_tot");
                temp.type = rs.getString("evaluation_type");
                temp.no = rs.getString("number");
                c.add(temp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void update_marks(String course, String sec, String evaname, String evanum, List<Evaluation> ls) {
        try {
            for (int i = 0; i < ls.size(); i++) {
                String temp = String.valueOf(ls.get(i).obtainedMarks);
                stmt.execute("update evaluation set marks_obt='" + temp + "' where student_rollno='" + ls.get(i).studentRollno
                        + "' and evaluation_type='" + evaname + "' and number='" + evanum + "' and course_name='" + course
                        + "' and section='" + sec + "'");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void getStudentsForAttendance_Marks(String course, String section, List<Student> ls) {
        try {
            ResultSet rs = stmt.executeQuery("Select studentid from registration where coursename='"
                    + course + "' and section='"
                    + section + "' and semester='"
                    + Admin.currentSemester + "'");

            while (rs.next()) {
                Student temp = new Student();
                temp.rollNo = rs.getString("studentid");
                System.out.println(temp.rollNo);
                ls.add(temp);
            }
            for (int i = 0; i < ls.size(); i++) {
                rs = stmt.executeQuery("Select name,lname,password,batch from student where id='" + ls.get(i).rollNo + "'");
                while (rs.next()) {

                    ls.get(i).fName = rs.getString("name");
                    ls.get(i).lName = rs.getString("lname");
                    ls.get(i).password = rs.getString("password");
                    ls.get(i).batch = rs.getString("batch");

                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    float getMarksForEvaluation(String course, String sec, String evaname, String evanumber, String stdid, List<Evaluation> ls) {
        float marks_obt = 0;
        try {
            ResultSet rs = stmt.executeQuery("select marks_obt from evaluation where student_rollno='" + stdid + "' and evaluation_type='" + evaname + "' and number='" + evanumber
                    + "' and course_name='" + course + "' and section='" + sec + "'");

            while (rs.next()) {
                Evaluation obj = new Evaluation();
                marks_obt = Float.valueOf(rs.getString("marks_obt"));
                obj.obtainedMarks = marks_obt;
                ls.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return marks_obt;
    }

    void getStudentInfo(String id, Student std) {
        try {
            ResultSet rs = stmt.executeQuery("Select address,phoneno,fathername,dob from student where id='" + id + "'");

            while (rs.next()) {
                std.address = rs.getString("address");
                std.phoneNo = rs.getString("phoneno");
                std.fatherOrGuardianName = rs.getString("fathername");
                std.dateOfBirth = rs.getString("dob");
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    void getLectureNo(String course, String sec, int lec, List<Integer> temp) {
        try {

            ResultSet rs = stmt.executeQuery("Select lecture_no from attendance where course_name='" + course + "' and"
                    + " section='" + sec + "'");
            while (rs.next()) {

                int o = rs.getInt("lecture_no");
                temp.add(o);

            }
            lec = temp.size();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    void add_Attendance(List<Attendance> c, String course, String section, String date) {
        try {
            Date temp = new Date();
            int lec = 0;
            List<Integer> temp1 = new ArrayList<>();
            getLectureNo(course, section, lec, temp1);
            lec = temp1.size();
            if (lec != 0) {
                lec = temp1.get(lec - 1);
            }
            lec = lec + 1;
            System.out.println(lec);
            for (int i = 0; i < c.size(); i++) {

                stmt.execute("Insert into attendance values (" + lec + ",'" + c.get(i).studentRollno + "','" + date + "','1.5','"
                        + course + "','" + Admin.currentSemester + "','" + section + "','"
                        + c.get(i).status + "')");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void update_Attendance(List<Attendance> c, String course, String section, String date, String lecno) {
        try {

            for (int i = 0; i < c.size(); i++) {

                stmt.execute("update attendance set istakenclass='" + c.get(i).status + "'where student_rollno='" + c.get(i).studentRollno + "' and lecture_no='" + lecno + "'");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    List<Course> getstudentcourses(String id) {
        try {
            List<Course> c = new ArrayList<Course>();

            ResultSet rs = stmt.executeQuery("select coursename,section from registration where studentid='" + id + "' and semester='" + Admin.currentSemester + "'");

            while (rs.next()) {
                Course temp = new Course();
                temp.courseName = rs.getString("coursename");
                temp.section = rs.getString("section");
                c.add(temp);
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    List<Course> getteachercourses(String id) {
        try {
            List<Course> c = new ArrayList<Course>();
            ResultSet rs = stmt.executeQuery("select distinct coursename,section from registration where instructorid='" + id + "' and semester='" + Admin.currentSemester + "'");

            int i = 0;
            while (rs.next()) {
                Course temp = new Course();
                temp.courseName = rs.getString("coursename");
                temp.section = rs.getString("section");
                i++;
                System.out.println(temp.courseName + " " + temp.section);
                c.add(temp);
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    List<Course> getallcourses() {
        try {
            List<Course> c = new ArrayList<Course>();
            ResultSet rs = stmt.executeQuery("select distinct coursename,section from registration where semester='" + Admin.currentSemester + "'");

            int i = 0;
            while (rs.next()) {
                Course temp = new Course();
                temp.courseName = rs.getString("coursename");
                temp.section = rs.getString("section");
                i++;

                c.add(temp);
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    List<Course> viewregisteredcourses(String id) {

        try {
            List<Course> c = new ArrayList<Course>();
//            for (int i = 0; i < 5; i++) {
//                Course obj = new Course();
//                c.add(obj);
//
//            }
            ResultSet rs = stmt.executeQuery("select coursename,section,grade from registration where studentid='" + id + "'");

            int i = 0;
            while (rs.next()) {
                Course obj = new Course();
                obj.courseName = rs.getString("coursename");
                obj.section = rs.getString("section");
                obj.grade = rs.getString("grade");
                c.add(obj);
                i++;

            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    void registerCourses(List<Course> c) {
        try {
            for (int i = 0; i < c.size(); i++) {

                int seats = getCourseSeats(c.get(i).courseName, c.get(i).section);
                int occupiedseats = 0;
                int temp2 = 0;

                if (seats <= 40) {

                    ResultSet rs2 = stmt.executeQuery("select COUNT(studentid) as a from registration where studentid='" + StudentGUI.id + "'");
                    while (rs2.next()) {
                        temp2 = Integer.parseInt(rs2.getString("a"));
                    }

                    if (temp2 > 5) {
                        JOptionPane.showMessageDialog(null, "More then 5 courses cannot be registered.");
                        return;
                    }

                    stmt.execute("Insert into registration values ('"
                            + getCourseCode(c.get(i).courseName) + "','" + c.get(i).courseName
                            + "','" + c.get(i).section + "','" + StudentGUI.id + "','I','"
                            + Admin.currentSemester + "','1')");

                    ResultSet rs = stmt.executeQuery("select total_seats from courses where name='" + c.get(i).courseName + "' and section='" + c.get(i).section + "'");
                    while (rs.next()) {
                        occupiedseats = Integer.parseInt(rs.getString("total_seats"));
                        break;
                    }
                    occupiedseats++;
                    String temp = Integer.toString(occupiedseats);
                    stmt.execute("update courses set total_seats='" + temp + "' where name='" + c.get(i).courseName + "' and section='"
                            + c.get(i).section + "'");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry! Seats not available.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    int getCourseSeats(String coursename, String section) {
        int numOfSeats = 0;
        try {
            ResultSet rs = stmt.executeQuery("select total_seats from courses where name='" + coursename + "' and section='" + section + "'");
            while (rs.next()) {
                numOfSeats = Integer.parseInt(rs.getString("total_seats"));
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return numOfSeats;
    }

    void setFeedback(String coursename, String section, String[] options) {
        try {
            for (int i = 0; i < options.length; i++) {
                stmt.execute("insert into stored_feedback values ('" + coursename + "','" + section + "','"
                        + StudentGUI.id + "','" + Admin.currentSemester + "','" + i + 1 + "','" + options[i] + "')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String getCourseCode(String c) {
        try {

            ResultSet rs = stmt.executeQuery("select id from courses where name='" + c + "'");

            while (rs.next()) {

                String s = rs.getString("id");
                return s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
