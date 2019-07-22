package com.stackroute.jdbc;

import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException, IOException {
        String res1;
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println();
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println();
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println();
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Mites","M");
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        int res=resultSetMetadataDemo.getColumnCount();
        System.out.println(res);

            //res1 = resultSetMetadataDemo.getTableName(2);
           // System.out.println(res1);
           // System.out.println();
           // JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
           // jdbcTransactionDemo.transactionUsingStatement();
           // jdbcTransactionDemo.transactionUsingPreparedStatement();



            JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
            jdbcBatchDemo.transactionUsingStatement();
            //jdbcBatchDemo.transactionUsingPreparedStatement();
          //  RowSetDemo rowSetDemo=new RowSetDemo();
           // rowSetDemo.rowSetImplement();
            //DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
           // databaseMetadataDemo.database();



    }
}
