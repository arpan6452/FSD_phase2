package flyaway;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import flyaway.model.Flight;
import flyaway.model.FlightTravelDetails;
import flyaway.model.Role;
import flyaway.model.User;

public class App {

	public static void main(String[] args) {

		/*
		 * Role role = new Role(); role.setName("Admin"); User user = new User();
		 * user.setFirstName("Arpan"); user.setLastName("Ghosh");
		 * user.setUserName("aghos"); user.setEmail("arpan@gmail.com");
		 * user.setPassword("Password"); user.setRole(role);
		 */
		Flight flight = new Flight();
		flight.setFlightName("Indigo");
		flight.setFlightCode("I1234J");
		flight.setPrice(7200);
		List<FlightTravelDetails> allFlightTravelDetails = new ArrayList<FlightTravelDetails>();
		FlightTravelDetails flightTravelDetails = new FlightTravelDetails();
		flightTravelDetails.setDepartureTime("2021-04-12T03:34");
		flightTravelDetails.setArrivalTime("2021-04-12T05:34");
		flightTravelDetails.setSource("Delhi");
		flightTravelDetails.setDestinaion("Jaipur");
		flightTravelDetails.setFlight(flight);
		allFlightTravelDetails.add(flightTravelDetails);
		FlightTravelDetails flightTravelDetails1 = new FlightTravelDetails();
		flightTravelDetails1.setDepartureTime("2021-05-13T06:34");
		flightTravelDetails1.setArrivalTime("2021-05-13T08:34");
		flightTravelDetails1.setSource("Jaipur");
		flightTravelDetails1.setDestinaion("Delhi");
		flightTravelDetails1.setFlight(flight);
		allFlightTravelDetails.add(flightTravelDetails1);
		flight.setFlightTravelDetails(allFlightTravelDetails);

		
		Configuration con = new Configuration().configure(new File(
				"C:\\Users\\arpaghos\\eclipse-workspace\\flyaway\\src\\main\\java\\flyaway\\hibernate-config.xml"))
				.addAnnotatedClass(Flight.class).addAnnotatedClass(FlightTravelDetails.class)
				.addAnnotatedClass(User.class).addAnnotatedClass(Role.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// flight = (Flight) session.get(Flight.class, 1);
		//session.save(allFlightTravelDetails);
		session.save(flight);		
		session.flush();
		transaction.commit();
		session.close();

		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory(
		 * "com.baeldung.movie_catalog"); EntityManager em = emf.createEntityManager();
		 * em.getTransaction().begin(); em.persist(flight);
		 * em.getTransaction().commit(); em.close();
		 */

		//System.out.println(flight);

	}

}
