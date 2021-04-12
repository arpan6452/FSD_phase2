package flyaway;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flight_id;
	private String source;
	private String destinaion;
	private String flightName;
	private double price;

	@OneToMany(mappedBy = "flight")
	private List<FlightTime> flight_Time = new ArrayList<FlightTime>();

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", source=" + source + ", destinaion=" + destinaion + ", flightName="
				+ flightName + ", price=" + price + ", flight_Time=" + flight_Time + "]";
	}

	public Flight() {
	}

	public List<FlightTime> getFlight_Time() {
		return flight_Time;
	}

	public void setFlight_Time(List<FlightTime> flight_Time) {
		this.flight_Time = flight_Time;
	}

	public String getSource() {
		return source;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinaion() {
		return destinaion;
	}

	public void setDestinaion(String destinaion) {
		this.destinaion = destinaion;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
