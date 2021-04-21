package flyaway.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import flyaway.model.Flight;
import flyaway.model.FlightTravelDetails;
import flyaway.model.Role;
import flyaway.model.User;

public class DBConnection {
	static DBConnection instance = null;
	private static SessionFactory sf;
	
	private DBConnection() {
		Configuration con = new Configuration().configure(new File(
				"C:\\Users\\arpaghos\\eclipse-workspace\\flyaway\\src\\main\\java\\flyaway\\hibernate-config.xml"))
				.addAnnotatedClass(Flight.class).addAnnotatedClass(FlightTravelDetails.class)
				.addAnnotatedClass(User.class).addAnnotatedClass(Role.class);
		//ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		//sf = con.buildSessionFactory(registry);
		sf = con.buildSessionFactory();
	}
	
	static public DBConnection getInstance()
    {
        if (instance == null)        
             instance = new DBConnection();
        return instance;
    }
	
	public SessionFactory getSession() {
		return sf;
	}
}
