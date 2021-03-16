package com.simplilearn.test.jdbctraning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingUpdatableResultSet {
	String qry;
	Connection mySQLConn;
	Statement theStatement;

	UsingUpdatableResultSet() {
		try {
			String mySQLDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mySQLDriver);
			String urltoConnect = "jdbc:mysql://localhost:3306/simplilearn";
			String dbUsername = "root";
			String dbPassword = "arpan@mySQL12";
			mySQLConn = DriverManager.getConnection(urltoConnect, dbUsername, dbPassword);
			System.out.println("Successfully connected to database..");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to initiate driver due to : " + e.getLocalizedMessage());
		} catch (SQLException e) {
			System.out.println("Unable to create connection due to : " + e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		UsingUpdatableResultSet app = new UsingUpdatableResultSet();
//		Scanner sc = new Scanner(System.in);		
		new UsingUpdatableResultSet().fetchAndUpdate();
//		sc.close();

	}

	void fetchAndUpdate() {
//		Write the query to fetch records from table:learners
		qry = "select * from students";

//		Get a reference to the PreparedStatement
		try {
			PreparedStatement pstmt = mySQLConn.prepareStatement(qry, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

//			Execute the query
			ResultSet theResultSet = pstmt.executeQuery();

//			Traverse through the results
			while (theResultSet.next()) {
				if (theResultSet.getInt("students_id") == 1) {
//					Update the current row
					theResultSet.updateString("address", theResultSet.getString("address") + " recently");

//					Commit the changes
					theResultSet.updateRow();

					System.out.println("Name updated...");
				}
			}

		} catch (SQLException e) {
			System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
		}
	}
}
