package flyaway;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		FlightTime flightTime = new FlightTime();
		flightTime.setId(101);
		flightTime.setDateofTravel(new Date(2021, 1, 2, 12, 30));
		
		Flight flight = new Flight();
		flight.setSource("Bangalore");
		flight.setDestinaion("Hydrabad");
		flight.setFlightName("Vistara");
		flight.setPrice(5200);
		flightTime.setFlight(flight);

		Configuration con = new Configuration().configure(new File(
				"C:\\Users\\arpaghos\\eclipse-workspace\\flyaway\\src\\main\\java\\flyaway\\hibernate-config.xml"))
				.addAnnotatedClass(Flight.class).addAnnotatedClass(FlightTime.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// flight = (Flight) session.get(Flight.class, 1);

		session.save(flight);
		session.save(flightTime);
		transaction.commit();

		System.out.println(flight);

	}

}
