package com.company.execute;

import java.sql.*;

public class CallableStatement01 {
	/*
	   In Java, if the return type of a method is "any data type" or "void" we name all as methods.
	   But in SQL, if sth returns "any data" it is called function if sth does not return any data it is call "procedure"


	 */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();

        //1.Example: Create a function which uses 2 parameters and returns the sum of the parameters
        //1.step: Type code to create function
        String sql1 = "CREATE OR REPLACE FUNCTION addf(num1 NUMBER, num2 NUMBER) RETURN NUMBER IS BEGIN RETURN num1 + num2; END;";

        //2.step:Execute the function
        boolean result1 = st.execute(sql1);
        System.out.println(result1);

        //3.step: How to call a function
        CallableStatement cst1 = con.prepareCall("{? = call addf(?, ?)}");

        //4.step: Use registerOutParameter(); method or result container and use set methods for parameters.
        cst1.registerOutParameter(1, Types.INTEGER);
        cst1.setInt(2, 10);
        cst1.setInt(3, 20);


        //5.step: Use execute method to get result for the specific values
        cst1.execute();

        //6.step: To result on the console use syso
        System.out.println(cst1.getInt(1));//30



        con.close();
        st.close();



    }

}
