package com.abc.kishan.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp  {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement =null;
		ResultSet resultSet =null;
		
		
		
		String url="jdbc:mysql:///abc";
		String username="root";
		String password="root123";
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("DriverManager Connection established Sucessfully....");
			if (connection!=null) {
				statement = connection.createStatement();
				}
			if (statement!=null) {
				 String sqlSelectQuery="select sid,sname,sage, ssalary from student";
				 resultSet = statement.executeQuery(sqlSelectQuery);
			}
			if (resultSet!=null) {
					System.out.println("SID\tSNAME\tSAGE\tSSALARY");
				while (resultSet.next()) {
				     System.out.println(resultSet.getInt(1) +"\t" + resultSet.getString(2) +"\t" +
						resultSet.getInt(3) +"\t" + resultSet.getDouble(4)  );
				
			}
				
			}
		} catch (SQLException se) {
			if(se.getErrorCode()==1406)
				System.out.println("Data is too long....");
			else if(se.getErrorCode()==1062)
				System.out.println("Dulplicate of Primary key value Coloumn....");
			else if(se.getErrorCode()==1136)
				System.out.println("Insufficient data provided by the user....");
			else if(se.getErrorCode()==1064)
				System.out.println("SQL Syntax Error...");
			else
				System.out.println("Some Exception occured...");
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if(statement!=null) {
					statement.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
			}
			try {
				if(connection!=null) {
					connection.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
			}
		}

	}

}
