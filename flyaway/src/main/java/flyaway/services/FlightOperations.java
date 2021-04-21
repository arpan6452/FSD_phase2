package flyaway.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flyaway.model.Flight;
import flyaway.model.FlightTravelDetails;
import flyaway.utils.DBConnection;

public class FlightOperations {

	public static void main(String args[]) {

		FlightOperations flightOperations = new FlightOperations();
		List<FlightTravelDetails> allFlightTravelDetails = new ArrayList<FlightTravelDetails>();
		FlightTravelDetails flightTravelDetails = new FlightTravelDetails();
		flightTravelDetails.setDepartureTime("2021-04-05T03:34");
		flightTravelDetails.setArrivalTime("2021-04-05T05:34");
		flightTravelDetails.setSource("Chennai");
		flightTravelDetails.setDestinaion("Bangalore");
		allFlightTravelDetails.add(flightTravelDetails);
		FlightTravelDetails flightTravelDetails1 = new FlightTravelDetails();
		flightTravelDetails1.setDepartureTime("2021-05-05T06:34");
		flightTravelDetails1.setArrivalTime("2021-05-05T08:34");
		flightTravelDetails1.setSource("Bangalore");
		flightTravelDetails1.setDestinaion("Chennai");
		allFlightTravelDetails.add(flightTravelDetails1);
		flightOperations.createAFlight("JetAirways", "JA0932", 5400, allFlightTravelDetails);
		//flightOperations.getAllFlights();

		FlightOperations flightOperations1 = new FlightOperations();
		List flights = flightOperations1.searchFlights("Chennai", "Bangalore", "2021-04-05");

		// List flights = flightOperations.getAllFlightsDetails();
		for (Iterator iterator = flights.iterator(); iterator.hasNext();) {
			FlightTravelDetails flightTravelDetails2 = (FlightTravelDetails) iterator.next();
			System.out.println("id: " + flightTravelDetails2.getId());
			System.out.println("id: " + flightTravelDetails2.getFlight().getFlightName());
			/*
			 * System.out.print("getArrivalTime: " + flightTravelDetails.getArrivalTime());
			 * System.out.println("getDestinaion: " + flightTravelDetails.getDestinaion());
			 * System.out.println("getSource: " + flightTravelDetails.getSource());
			 * System.out.println("getFlight: " + flightTravelDetails.getFlight());
			 */
		}

	}

	public List getAllFlights() {
		DBConnection dbconnection = DBConnection.getInstance();		
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		List flights = session.createQuery("FROM Flight").list();
		session.flush();
		transaction.commit();
		session.close();
		return flights;
	}

	public List getAllFlightsDetails() {
		DBConnection dbconnection = DBConnection.getInstance();
		System.out.println(dbconnection);
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		List flights = session.createQuery("FROM FlightTravelDetails").list();
		session.flush();
		transaction.commit();
		session.close();
		return flights;
	}

	public void createAFlight(String flightName, String flightCode, double price,
			List<FlightTravelDetails> allFlightTravelDetails) {
		Flight flight = new Flight();
		flight.setFlightName(flightName);
		flight.setFlightCode(flightCode);
		flight.setPrice(price);
		for (int loop = 0; loop < allFlightTravelDetails.size(); loop++) {
			allFlightTravelDetails.get(loop).setFlight(flight);
		}
		flight.setFlightTravelDetails(allFlightTravelDetails);
		DBConnection dbconnection = DBConnection.getInstance();
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(flight);
		session.flush();
		transaction.commit();
		session.close();
	}

	public List searchAFlight(String source, String destination, Date departureDate) {
		DBConnection dbconnection = DBConnection.getInstance();
		System.out.println(dbconnection);
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		List flights = session.createQuery(
				"select flight.flightName, flight.flightCode, flight.price FROM Flight flight where flight.flight_id=1")
				.list();
		session.flush();
		transaction.commit();
		session.close();
		return flights;
	}

	public List searchFlights(String source, String destination, String departureDate) {
		DBConnection dbconnection = DBConnection.getInstance();
		SessionFactory sf = dbconnection.getSession();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		List flights = session.createQuery(
				"select flightTravelDetails FROM FlightTravelDetails flightTravelDetails where flightTravelDetails.source='"
						+ source + "' and flightTravelDetails.destination='" + destination
						+ "' and flightTravelDetails.departureTime like '" + departureDate + "%'")
				.list();
		
		session.flush();
		transaction.commit();
		session.close();
		return flights;
	}

}
