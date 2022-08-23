package damla_jdbc_examples;

import java.sql.*;
import java.util.Scanner;


public class Q01 {

    /*
        1) Create firstGrade table
        2) Create secondGrade table
        3) Add student_id, student_name, student_math_score for firstGradeTable
        4) Add student_id, student_name, student_english_score for secondGradeTable
        4) Insert 10 students values for firstGrade Table and Insert 7 students values for secondGrade Table
        5) Select student_name and student_math_score from firstTable
        6) Select the student_name and student_id whose math score is the highest
        7) Select the number of students whose english score is less than 50 per student
     */



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();

        /*
         String firstGradeTable = "CREATE TABLE first_grade " + "(student_id CHAR(4), " + "student_name VARCHAR2(20), " + "student_math_score NUMBER(3))";
        boolean resulFirstGradeTable = st.execute(firstGradeTable);
        System.out.println(resulFirstGradeTable);


        String secondGradeTable = "CREATE TABLE second_grade " + "(student_id CHAR(4), " + "student_name VARCHAR2(20), " + "student_english_score NUMBER(3))";
        boolean resulSecondGradeTable = st.execute(secondGradeTable);
        System.out.println(resulSecondGradeTable);




        int f1 = st.executeUpdate("INSERT INTO first_grade VALUES (101, 'Damla', 100)");
        int f2 = st.executeUpdate("INSERT INTO first_grade VALUES (108, 'Emir', 90)");
        int f3 = st.executeUpdate("INSERT INTO first_grade VALUES (109, 'Özge', 70)");
        int f4 = st.executeUpdate("INSERT INTO first_grade VALUES (110, 'Gökçe', 20)");
        int f5 = st.executeUpdate("INSERT INTO first_grade VALUES (103, 'Dilara', 30)");
        int f6 = st.executeUpdate("INSERT INTO first_grade VALUES (102, 'Gonca', 80)");
        int f7 = st.executeUpdate("INSERT INTO first_grade VALUES (105, 'Serra', 80)");
        int f8 = st.executeUpdate("INSERT INTO first_grade VALUES (104, 'Güzin', 90)");
        int f9 = st.executeUpdate("INSERT INTO first_grade VALUES (107, 'Kayra', 40)");
        int f10 = st.executeUpdate("INSERT INTO first_grade VALUES (106, 'Ceyda', 30)");

        int sumFirst = f1+f2+f3+f4+f5+f6+f7+f8+f9+f10;
        if (sumFirst == 10){
            System.out.println("Insert Into Successfully");
        }else{
            System.out.println("Insert Into Does Not Successfully");
        }


        int s1 = st.executeUpdate("INSERT INTO second_grade VALUES (101, 'Zelal', 90)");
        int s2 = st.executeUpdate("INSERT INTO second_grade VALUES (111, 'Aslı', 60)");
        int s3 = st.executeUpdate("INSERT INTO second_grade VALUES (109, 'Tuğçe', 40)");
        int s4 = st.executeUpdate("INSERT INTO second_grade VALUES (206, 'Ahmet', 10)");
        int s5 = st.executeUpdate("INSERT INTO second_grade VALUES (204, 'Zelal', 20)");
        int s6 = st.executeUpdate("INSERT INTO second_grade VALUES (108, 'Damla', 60)");
        int s7 = st.executeUpdate("INSERT INTO second_grade VALUES (103, 'Güzin', 90)");
        int s8 = st.executeUpdate("INSERT INTO second_grade VALUES (105, 'Özge', 40)");

        int sumSecond = s1+s2+s3+s4+s5+s6+s7+s8;


        if (sumSecond==8){
            System.out.println("Insert Into Successfully");
        }else{
            System.out.println("Insert Into Does Not Successfully");
        }


         */

        // Select student_name and student_math_score from firstTable
        String studentNameAndMathScore = "SELECT student_name, student_math_score FROM first_grade";

        ResultSet resultForNameAndMathScore = st.executeQuery(studentNameAndMathScore);
        while (resultForNameAndMathScore.next()){
            System.out.println(resultForNameAndMathScore.getString(1) + "-->" + resultForNameAndMathScore.getInt(2));
        }

        System.out.println("===========================");

        //Select the student_name and student_id whose math score is the highest
        String highestMathScore = "SELECT student_name, student_id FROM first_grade " +
                "WHERE student_math_score = (SELECT MAX(student_math_score)FROM first_grade)";
        ResultSet resultForHighestMathScore = st.executeQuery(highestMathScore);
        while (resultForHighestMathScore.next()){
            System.out.println(resultForHighestMathScore.getString(1) + "-->"+ resultForHighestMathScore.getInt(2));
        }





    }







}
