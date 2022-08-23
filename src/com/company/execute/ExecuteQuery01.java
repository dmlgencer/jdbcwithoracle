package com.company.execute;
import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr", "hr");

        Statement st = con.createStatement();

        //1.Example: Find the company and the number_of_employees whose number_of_employees is the second highest from companies table

        String sql = "SELECT company, number_of_employees \r\n"
                + "FROM companies WHERE number_of_employees = \r\n"
                + "(SELECT MAX(number_of_employees)\r\n"
                + "FROM companies\r\n"
                + "WHERE number_of_employees < (SELECT MAX(number_of_employees) FROM companies))";

        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            System.out.println(result.getString(1) + "->" + result.getInt(2));
        }

        System.out.println("==============================");


        //2.Example: Find the company names and number of employees whose number of employees is less than the average number of employees
        String sql2 = "SELECT company, number_of_employees\r\n"
                + "FROM companies\r\n"
                + "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies)";

        ResultSet result2 = st.executeQuery(sql2);
        while(result2.next()) {
            System.out.println(result2.getString(1) + "->" + result2.getInt(2));
        }



        con.close();
        st.close();
    }



}

