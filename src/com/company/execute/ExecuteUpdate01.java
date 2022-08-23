package com.company.execute;

import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1 = "UPDATE companies\r\n"
                + "SET number_of_employees = 16000\r\n"
                + "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies)";

        int numOfRecordsUpdated1 = st.executeUpdate(sql1);
        System.out.println(numOfRecordsUpdated1 + " row/s updated");


        String sql2 = "SELECT * FROM companies";
        ResultSet result = st.executeQuery(sql2);

        while(result.next()) {
            System.out.println(result.getInt(1) + "-" + result.getString(2) + "-" + result.getInt(3));
        }



        con.close();
        st.close();




    }

}
