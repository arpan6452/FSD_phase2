package com.simplilearn.test.jdbctraning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	String qry;
	Connection mySQLConn;
	Statement theStatement;

	App() {
		try {
			String mySQLDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mySQLDriver);
			String urltoConnect = "jdbc:mysql://localhost:3306/simplilearn";
			String dbUsername = "root";
			String dbPassword = "arpan@mySQL12";
			mySQLConn = DriverManager.getConnection(urltoConnect, dbUsername, dbPassword);
			theStatement = mySQLConn.createStatement();
			System.out.println("Successfully connected to database..");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to initiate driver due to : " + e.getLocalizedMessage());
		} catch (SQLException e) {
			System.out.println("Unable to create connection due to : " + e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		App app = new App();		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.next();
		System.out.println("Enter address: ");
		String address = sc.next();
		System.out.println("Enter students id: ");
		int id = sc.nextInt();
		// app.addStudentsRuntime(name, address);
		app.updateStudentsRuntime( id, name, address);
		//app.deleteStudentsRuntime(id);
		app.getAllRecords();
		sc.close();

	}

	void getAllRecords() {
		qry = "select * from students";
		try {
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

	void addStudentsRuntime(String name, String address) {
		qry = "INSERT INTO students (name, address) VALUES " + " ('" + name + "', '" + address + "');";
		int resultSet;
		try {
			resultSet = theStatement.executeUpdate(qry);

			if (resultSet > 0)
				System.out.println("Student record has been succesfully added");
		} catch (SQLException e) {
			System.out.println("Unable to add new student due to : " + e.getLocalizedMessage());
		}

	}

	void updateStudentsRuntime(int students_id, String newName, String newAddress) {
		qry = "UPDATE students " + "SET name = '" + newName + "',address = '" + newAddress + "'  WHERE students_id = '"
				+ students_id + "'";
		int resultSet;
		try {
			theStatement = mySQLConn.createStatement();
			resultSet = theStatement.executeUpdate(qry);

			if (resultSet > 0)
				System.out.println("Student record has been succesfully updated");
		} catch (SQLException e) {
			System.out.println("Unable to update student due to : " + e.getLocalizedMessage());
		}

	}

	void deleteStudentsRuntime(int students_id) {
		qry = "DELETE FROM students WHERE students_id = '" + students_id + "'";
		int resultSet;
		try {
			theStatement = mySQLConn.createStatement();
			resultSet = theStatement.executeUpdate(qry);

			if (resultSet > 0)
				System.out.println("Student record has been succesfully deleted");
		} catch (SQLException e) {
			System.out.println("Unable to delete student due to : " + e.getLocalizedMessage());
		}

	}
}
