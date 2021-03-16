package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Manager {
	String qry;
	Connection mySQLConn;
	Statement theStatement;

	public JDBC_Manager() {
	}

	public void JDBC_SetUp() {
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
		JDBC_Manager app = new JDBC_Manager();
		Scanner sc = new Scanner(System.in);
		app.JDBC_SetUp();
		/*
		 * app.addLearnersRuntime("MS", "Dhoni", "Bihar");
		 * app.addLearnersRuntime("Virat", "Kohli", "Bangalore");
		 * app.addLearnersRuntime("Suresh", "Raina", "UP");
		 * app.addLearnersRuntime("Sourav", "Ganguly", "WestBengal");
		 * 
		 * app.getAllLearnerRecords(); app.getLearnerDetailsByName("Arpan", "Ghosh");
		 * app.getLearnerDetailsByAddress("Bihar");
		 */
		app.getAllLearnerRecords();
		app.updateStudentsRuntime(2, "Arpan", "Ghosh", "WestBengal");
		app.getAllLearnerRecords();
		/*
		 * app.deleteLearnersRuntime(1);
		 * 
		 * app.sortStudentsTable("LastName");
		 */
		// app.getAllLearnerRecords();
		sc.close();

	}

	public void getAllLearnerRecords() {
		qry = "select * from Learners";
		try {
			theStatement = mySQLConn.createStatement();
			ResultSet resultSet = theStatement.executeQuery(qry);

			while (resultSet.next()) {
				System.out.print("Learner Id : " + resultSet.getInt("LearnerId") + " ");
				System.out.print("Learner Name : " + resultSet.getString("FirstName") + " "
						+ resultSet.getString("LastName") + " ");
				System.out.println("Learner Address : " + resultSet.getString("Address"));
			}
			System.out.println("");
		} catch (SQLException e) {
			System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
		}
	}

	public void getLearnerDetailsByAddress(String Address) {
		qry = "select * from Learners where Address = ?";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, Address);
			ResultSet resultSet = thePrepareStatement.executeQuery();

			while (resultSet.next()) {
				System.out.print("Learner Id : " + resultSet.getInt("LearnerId") + " ");
				System.out.print("Learner Name : " + resultSet.getString("FirstName") + " "
						+ resultSet.getString("LastName") + " ");
				System.out.println("Learner Address : " + resultSet.getString("Address"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
		}
	}

	public void getLearnerDetailsByName(String FirstName, String LastName) {
		qry = "select * from Learners where FirstName = ? AND LastName = ?";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, FirstName);
			thePrepareStatement.setString(2, LastName);
			ResultSet resultSet = thePrepareStatement.executeQuery();

			while (resultSet.next()) {
				System.out.print("Learner Id : " + resultSet.getInt("LearnerId") + " ");
				System.out.print("Learner Name : " + resultSet.getString("FirstName") + " "
						+ resultSet.getString("LastName") + " ");
				System.out.println("Learner Address : " + resultSet.getString("Address"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to fetch all data due to : " + e.getLocalizedMessage());
		}
	}

	public void addLearnersRuntime(String FirstName, String LastName, String Address) {
		qry = "INSERT INTO Learners (FirstName, LastName, Address) VALUES (?,?,?)";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, FirstName);
			thePrepareStatement.setString(2, LastName);
			thePrepareStatement.setString(3, Address);

			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("New Learner has been succesfully added");
			else
				System.out.println("Learner not found");
		} catch (SQLException e) {
			System.out.println("Unable to add new Learners due to : " + e.getLocalizedMessage());
		}

	}

	public void updateStudentsRuntime(int LearnerId, String FirstName, String LastName, String Address) {
		qry = "UPDATE Learners " + "SET FirstName = ?,LastName = ?, Address = ?  WHERE LearnerId = ?";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setString(1, FirstName);
			thePrepareStatement.setString(2, LastName);
			thePrepareStatement.setString(3, Address);
			thePrepareStatement.setInt(4, LearnerId);

			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("Learner record has been succesfully updated");
			else
				System.out.println("Learner not found");
		} catch (SQLException e) {
			System.out.println("Unable to update Learners due to : " + e.getLocalizedMessage());
		}

	}

	public void deleteLearnersRuntime(int LearnerId) {
		qry = "DELETE FROM Learners WHERE LearnerId = ? ";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);
			thePrepareStatement.setInt(1, LearnerId);

			if (thePrepareStatement.executeUpdate() > 0)
				System.out.println("Learners record has been succesfully deleted");
			else
				System.out.println("Learner not found");
		} catch (SQLException e) {
			System.out.println("Unable to delete Learners due to : " + e.getLocalizedMessage());
		}

	}

	public void sortStudentsTable(String cloumnName) {
		qry = "select * from Learners ORDER BY " + cloumnName + " ASC";
		try {
			PreparedStatement thePrepareStatement = mySQLConn.prepareStatement(qry);

			ResultSet resultSet = thePrepareStatement.executeQuery();
			while (resultSet.next()) {
				System.out.print("Learner Id : " + resultSet.getInt("LearnerId") + " ");
				System.out.print("Learner Name : " + resultSet.getString("FirstName") + " "
						+ resultSet.getString("LastName") + " ");
				System.out.println("Learner Address : " + resultSet.getString("Address"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to update Learners due to : " + e.getLocalizedMessage());
		}

	}

}
