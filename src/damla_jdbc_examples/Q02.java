package damla_jdbc_examples;
import java.sql.*;
public class Q02 {



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();


        //1) Select all information whose math score is the lowest score from first_grade
        String lowestMath = ("SELECT * FROM first_grade WHERE student_math_score = (SELECT MIN(student_math_score) FROM first_grade)");
        ResultSet result1 = st.executeQuery(lowestMath);
        while (result1.next()) {
            System.out.println("Student all information whose math score is the lowest");
            System.out.println("Student id: " +
                    result1.getInt(1) +
                    "\nStudent name: " + result1.getString(2) +
                    "\nStudent math score: " + result1.getInt(3));
            System.out.println("---------------------------------------------------------");
        }

        //2)select all information whose english score is the second-highest score from second grade
        String secondHighestEnglishScore = "SELECT *\n" +
                "FROM second_grade\n" +
                "WHERE student_english_score = (SELECT MAX(student_english_score)\n" +
                "                            FROM second_grade\n" +
                "                            WHERE student_english_score < (SELECT MAX(student_english_score)\n" +
                "                            FROM second_grade))";


        ResultSet result2 = st.executeQuery(secondHighestEnglishScore);
        while (result2.next()){

            System.out.println("Student id: " +
                    result2.getInt(1) +
                    "\nStudent name: " + result2.getString(2)+
                    "\nStudent english score: "+ result2.getInt(3));

            }





    }






}
