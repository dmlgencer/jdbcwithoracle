package damla_jdbc_examples;
import java.sql.*;

public class Q03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{



//1) Update the student_math_score to 60 whose math score is less than average math score and print new table with 'n rows updated'
        String updateMathScore = "UPDATE fırst_grade " +
                                    "SET student_math_score = 100 " +
                                     "WHERE student_math_score < (SELECT AVG(student_math_score) FROM first_grade)";

        String afterUpdatingMathScore = "SELECT * FROM first_grade";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();


        int numOfUpdate = st.executeUpdate(updateMathScore);
        System.out.println(numOfUpdate +  " rows updated");









    }


}
