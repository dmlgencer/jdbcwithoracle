package com.company.execute;
import java.sql.*;//1.step: do import, it is like having phone machine

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //2.step: registration to the driver, it is like registering to communication company like AT&T
        Class.forName("oracle.jdbc.driver.OracleDriver");


        //3.step: Create a connection with database, it is like calling your friend
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr", "hr");

        //4.step: create statement, it is like talking with your friend
        Statement st = con.createStatement();

        //5.step: Execute the query, it is like sending your message to your friend

        /*
            execute() method can be used in DDL(Table creation, drop table, alter table) and DQL(SELECT)
        	1) If you use execute() method in DDL you will get false everytime
        	2) If you use execute() method in DQL you will get true or false
        		When you use execute() method in DQL, if you get ResultSet Object as return, you will get true
        		otherwise you will get false.



         */

        //1. Example: Create a workers table with the colomns worker_id, worker_name, worker_salary
        String sql = "CREATE TABLE workers (worker_id CHAR(3), worker_name VARHCHAR2(20), worker_salary NUMBER(20))";
        boolean result = st.execute("CREATE TABLE workers (worker_id CHAR(3), worker_name VARCHAR2(50), worker_salary NUMBER(7,2))");
        System.out.println("execute() method returned: " + result + " for table creation");//I got false from here it means no record returned

        //2.Example: Alter table by adding worker_address colomn into the workers table
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR2(50)";
        boolean result2 = st.execute(sql2);
        System.out.println("execute() method returned: " + result2 + " for table altering");


        //3.Example: Drop workers table
//        String sql3 = "DROP TABLE workers";
//        boolean result3 = st.execute(sql3);
//        System.out.println("execute() method returned: " + result3 + " for table dropping");
//
//

        //6.step: close the con, and st.
        con.close();
        st.close();







    }
}

