package com.stackroute.jdbc;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.sun.rowset.JdbcRowSetImpl;

public class RowSetDemo {
    public void rowSetImplement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Root@123");)
        {

            JdbcRowSetImpl jdbcimpl=new JdbcRowSetImpl(con);
            jdbcimpl.setUrl("jdbc:mysql://localhost:3306/mydb");
            jdbcimpl.setUsername("Root");
            jdbcimpl.setPassword("Root@123");
            jdbcimpl.setCommand("select * from employee");
            jdbcimpl.execute();
            jdbcimpl.addRowSetListener(new MyListener());
            while (jdbcimpl.next()) {

                System.out.println("Id: " + jdbcimpl.getInt(1));
                System.out.println("Name: " + jdbcimpl.getString(2));
                System.out.println("age"  + jdbcimpl.getInt(3));
                System.out.println("gender"+jdbcimpl.getString(4));
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
class MyListener implements RowSetListener {
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved...");
    }
    public void rowChanged(RowSetEvent event) {
        System.out.println("Cursor Changed...");
    }
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("RowSet changed...");
    }
}
