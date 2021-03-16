package com.simplilearn.test.jdbctraning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsingPrepareStatement {
	String qry;
	Connection mySQLConn;
	Statement theStatement;

	UsingPrepareStatement() {
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
		UsingPrepareStatement app = new UsingPrepareStatement();
		Scanner sc = new Scanner(System.in);		
		
//		  System.out.println("Enter name: "); 
//		  String name = sc.next();
//		  System.out.println("Enter address: "); 
//		  String address = sc.next();
//		 
//		System.out.println("Enter students id: ");
//		int id = sc.nextInt();
		//app.deleteStudentsRuntime(id);
		//app.getstudetnsDetailsById(id);
		//app.addStudentsRuntime(name, address);
//		app.updateStudentsRuntime(id, name, address);
		//app.deleteStudentsRuntime(id);
		app.getAllRecords();
		sc.close();

	}

	void getAllRecords() {
		qry = "select * from students";
		try {
			theStatement = mySQLConn.createStatement();
			ResultSet resultSet = theStatement.executeQuery(qry);

			while (resultSet.next()) {
				System.out.print("Id : " + resultSet.getInt("students_id") + " ");
				System.out.print("Name : " + resultSet.getString("name") + " ");
				System.out.println("Address : " + resultSet.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
		}
	}
	
	void getstudetnsDetailsById(int students_id) {
		qry = "select * from students where students_id = ?";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setInt(1, students_id);
			ResultSet resultSet = thePrepareStatement.executeQuery();

			while (resultSet.next()) {
				System.out.print("Id : " + resultSet.getInt("students_id") + " ");
				System.out.print("Name : " + resultSet.getString("name") + " ");
				System.out.println("Address : " + resultSet.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
		}
	}

	void addStudentsRuntime(String name, String address) {
		qry = "INSERT INTO students (name, address) VALUES (?,?)";		
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, name);
			thePrepareStatement.setString(2, address);
			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("Student record has been succesfully added");
		} catch (SQLException e) {
			System.out.println("Unable to add new student due to : " + e.getLocalizedMessage());
		}

	}

	void updateStudentsRuntime(int students_id, String newName, String newAddress) {
		qry = "UPDATE students " + "SET name = ?,address = ?  WHERE students_id = ?";		
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, newName);
			thePrepareStatement.setString(2, newAddress);
			thePrepareStatement.setInt(3, students_id);
			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("Student record has been succesfully updated");
		} catch (SQLException e) {
			System.out.println("Unable to update student due to : " + e.getLocalizedMessage());
		}

	}

	void deleteStudentsRuntime(int students_id) {
		qry = "DELETE FROM students WHERE students_id = ? ";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setInt(1, students_id);

			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("Student record has been succesfully deleted");
		} catch (SQLException e) {
			System.out.println("Unable to delete student due to : " + e.getLocalizedMessage());
		}

	}
}
