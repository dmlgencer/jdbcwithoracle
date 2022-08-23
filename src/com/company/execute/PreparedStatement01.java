package com.company.execute;

import java.sql.*;
public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();

        //NOTE: prepared statement is used for complicated queries not to type them again and again for every task
        //		you type them once by using "?" and then you execute it.

        //1.Example: Update the number of employees to 9999 if the company name is IBM
        String sql = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        PreparedStatement pst1 = con.prepareStatement(sql);

        pst1.setInt(1, 9999);//1 means first "?"
        pst1.setString(2, "IBM");

        int numOfUpdatedRecords = pst1.executeUpdate();
        System.out.println(numOfUpdatedRecords + " rows updated");

        //see the updated table

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while(result1.next()) {
            System.out.println(result1.getInt(1) + "-" + result1.getString(2) + "-" + result1.getInt(3));
        }

        //2.Exapmle: Use prepared statement in "SELECT * FROM <table name>"
        String sql4 = "SELECT * FROM ?";
        PreparedStatement pst2 = con.prepareStatement(sql4);

        pst2.setString(1, "countries");

        ResultSet result3 = pst2.executeQuery();

        while(result3.next()) {
            System.out.println(result3.getString(1) + "-" + result3.getString(2) + "-" + result3.getInt(3));

        }









        con.close();
        st.close();


    }

}

