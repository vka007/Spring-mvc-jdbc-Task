package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo
{

    public void transactionUsingStatement() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Root@123");
             Statement statement = con.createStatement();
           ) {


            con.setAutoCommit(false);


            String sqlQuery = "INSERT INTO employee (id, name, age, gender) " +
                    "VALUES(200,'Zia', 45, 'M')";

            statement.addBatch(sqlQuery);
            sqlQuery = null;

            sqlQuery = "INSERT INTO employee (id, name, age, gender) " +
                    "VALUES(20,'Animesh',50,'M')";

            statement.addBatch(sqlQuery);
            sqlQuery = null;

            sqlQuery = "UPDATE employee SET age = 35 " +
                    "WHERE id = 1";

            statement.addBatch(sqlQuery);

            int[] count = statement.executeBatch();


            con.commit();


        }catch (Exception e)
            {   e.printStackTrace();

            }
    }
    public void transactionUsingPreparedStatement() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Root@123");
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {


            con.setAutoCommit(false);


            String SQL = "INSERT INTO employee (id, name, age, gender) " +
                    "VALUES(?, ?, ?, ?)";


            PreparedStatement pstmt = con.prepareStatement(SQL);


            con.setAutoCommit(false);

            pstmt.setInt(1, 400);
            pstmt.setString(2, "Jai");
            pstmt.setInt(3, 45);
            pstmt.setString(4, "M");

            pstmt.addBatch();


            con.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
