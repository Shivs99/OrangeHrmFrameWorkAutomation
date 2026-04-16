package com.orangehrm.database_utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {

	Connection con;

	public boolean getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql//localhost:3306/jdbc";
		String username = "root";
		String password = "6396";
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String message = "Connection Established Successfully";
		return true;
	}

	public void readDataFromDb() {
		if (getConnection()) {
			try {
				Statement st = con.createStatement();
				String query = "select * from Employee";
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					System.out.println(
							rs.getString(0) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is Not Established...");
		}
	}

	public void insertDataIntoTable() {
		if (getConnection()) {
			try {
				Statement st = con.createStatement();
				String query = "create table Employee(FirstName varchar2(10),MiddleName varchar2(10),LastName varchar2(10))";
				st.executeUpdate(query);
				String insertQuery = "insert into Employee values(Shiva,Prasad,s,101)";
				int rows = st.executeUpdate(insertQuery);
				System.out.println(rows + " Inserted Successfully...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is Not Establieshed");
		}
	}

	public void closeDatabaseconnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
