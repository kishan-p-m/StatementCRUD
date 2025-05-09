package com.abc.kishan.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement =null;

		
		
		
		String url="jdbc:mysql:///abc";
		String username="root";
		String password="root123";
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("DriverManager Connection established Sucessfully...");
			if (connection!=null) {
				statement = connection.createStatement();
				}
			if (statement!=null) {
				 String sqlUpdateQuery= "update student set sname='MSD' where sid=7 ";
				 int rowCount = statement.executeUpdate(sqlUpdateQuery);
				
				if(rowCount>0) {
					System.out.println("Row Updated  Sucessfully....");
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
