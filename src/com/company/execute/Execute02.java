package com.company.execute;
import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //On SQL Developer by typing "SHOW Connection" you can find the url.
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

        Statement st = con.createStatement();

        //1.Example: Select the country names whose region id's are 1
        String sql = "SELECT country_name FROM countries WHERE region_id = 1";
        ResultSet result = st.executeQuery(sql);

        while (result.next()){
            System.out.println(result.getString(1));
        }

        System.out.println("=====================================");

        //2.Example: Select the country ids and country names whose region id's are greter than 2
        String sql1 = "SELECT country_name, country_id FROM countries WHERE region_id>2";
        ResultSet result2 = st.executeQuery(sql1);

        while (result2.next()){
            System.out.println(result2.getString(1) + "-->" +  result2.getString(2));
        }

        System.out.println("========================================");
        //3.Example: Select the company whose number of employees is the lowest from companies table
        String sql2 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";

        ResultSet result3 = st.executeQuery(sql2);
        while (result3.next()){
            System.out.println(result3.getString(1) + result3.getString(2) + result3.getInt(3));

        }

        con.close();
        st.close();


    }
}
