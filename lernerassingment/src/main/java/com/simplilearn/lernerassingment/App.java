package com.simplilearn.lernerassingment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.simplilearn.controller.LearnerController;
import com.simplilearn.jdbc.JDBC_Manager;
import com.simplilearn.model.LearnersBean;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to : Company Lockers Pvt. Ltd.");
		System.out.println("Developer Details:");
		System.out.println("Name: Arpan Ghosh");
		System.out.println("Title: Senior Quality Engineer \n");

		// initially assigning the userInput as 1 so that while condition executes
		String userInput = "1";
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(System.in);
		try {
			LearnersBean learnersBean = new LearnersBean();
			JDBC_Manager jdbc_Manager = new JDBC_Manager();
			LearnerController learnerController = new LearnerController(jdbc_Manager, learnersBean);
			jdbc_Manager.JDBC_SetUp();

			// printing the message and showing them the options to display
			// FileManagerImpl fileManagerImpl = new FileManagerImpl();
			while (!userInput.equalsIgnoreCase("7")) {
				System.out.println("Please enter 1: if you want to add new a learner ");
				System.out.println("Please enter 2: if you want to update a learner");
				System.out.println("Please enter 3: if you want to delete a learner");
				System.out.println("Please enter 4: if you want to search a learner");
				System.out.println("Please enter 5: if you want to display all learner");
				System.out.println("Please enter 6: if you want to sort all learner");
				System.out.println("Please enter 7: if you want to close the application");
				userInput = sc.readLine();
				switch (userInput) {
				case "1":
					System.out.println("Please enter the learner first name: ");
					String firstName = sc.readLine();
					learnersBean.setFirstName(firstName);
					System.out.println("Please enter the learner last name: ");
					String lastName = sc.readLine();
					learnersBean.setLastName(lastName);
					System.out.println("Please enter the learner address name: ");
					String address = sc.readLine();
					learnersBean.setAddress(address);

					// any of the field should not be blank
					if (firstName.equals("") || lastName.equals("") || address.equals(""))
						System.out.println("Learner firstname, lastname or address can not be blank");
					else
						learnerController.createNewLearner(learnersBean);
					break;
				case "2":
					System.out.println("Please enter the learner new first name: ");
					firstName = sc.readLine();
					learnersBean.setFirstName(firstName);
					System.out.println("Please enter the learner new last name: ");
					lastName = sc.readLine();
					learnersBean.setLastName(lastName);
					System.out.println("Please enter the learner new address: ");
					address = sc.readLine();
					learnersBean.setAddress(address);
					System.out.println("Please enter the learner id for which you want to update: ");
					int learnerID = Integer.parseInt(sc.readLine());
					learnersBean.setLearner_id(learnerID);
					if (firstName.equals("") || lastName.equals("") || address.equals(""))
						System.out.println("Learner firstname, lastname, address or learner id can not be blank");
					else
						learnerController.updateLearnerDetails(learnersBean);
					break;
				case "3":
					System.out.println("Please enter the Learner Id you want to delete: ");
					learnerID = Integer.parseInt(sc.readLine());
					learnerController.deleteLearner(learnerID);
					break;
				case "4":
					System.out.println("Please enter the field by which you want to search a learner: ");
					String fieldName = sc.readLine();
					if (fieldName.equalsIgnoreCase("address")) {
						System.out.println("Please enter the learner address for which you want to search: ");
						address = sc.readLine();
						learnerController.searchLearnerByAddress(address);
					} else if (fieldName.equalsIgnoreCase("name")) {
						System.out.println("Please enter the learner first name for which you want to search: ");
						firstName = sc.readLine();
						learnersBean.setFirstName(firstName);
						System.out.println("Please enter the learner last name for which you want to search:: ");
						lastName = sc.readLine();
						learnersBean.setLastName(lastName);
						learnerController.searchLearnerByName(firstName, lastName);
					} else
						System.out.println("Please enter a valid field");
					break;
				case "5":
					learnerController.displayAllLearners();
					break;
				case "6":
					System.out.println("Please enter the attribute which you want to sort:Press 1 for FirstName, 2 for LastName, 3 for Address ");
					String attribute = sc.readLine();
					if(attribute.equals(1)) {
						learnerController.sortLearner("FirstName");
					} else if(attribute.equals(2)) {
						learnerController.sortLearner("LastName");
					} else if(attribute.equals(3)) {
						learnerController.sortLearner("Address");
					} else {
						System.out.println("Please enter a valid option");
					}
					
					break;
				case "7":
					System.out.println("Are you sure you want to quit? yes/no");
					userInput = sc.readLine();
					if (userInput.equalsIgnoreCase("no")) {
					} else {
						userInput = "7";
						System.out.println("Bye! Hope you had a great exprience.");
					}
					break;
				default:
					System.out.println("Please select any of the correct option from the above list");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Application is down.Please connect after sometime");
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
