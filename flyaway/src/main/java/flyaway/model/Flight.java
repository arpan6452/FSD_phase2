package flyaway.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flight_id;
	private String flightName;
	private double price;
	private String flightCode;

	

	@OneToMany( cascade = { CascadeType.ALL })
	/*
	 * @JoinTable(name="FlightAcc", joinColumns={@JoinColumn(name="FlightID",
	 * referencedColumnName="flight_id")} ,
	 * inverseJoinColumns={@JoinColumn(name="FlightDetailsID",
	 * referencedColumnName="id")})
	 */
	@JoinColumn(name="flightDetails")
	private List<FlightTravelDetails> flightTravelDetails;// = new ArrayList<FlightTravelDetails>();;

	public Flight() {
	}

	public Flight(int flight_id, String flightName, double price,String flightCode, List<FlightTravelDetails> flightTravelDetails) {
		super();
		this.flight_id = flight_id;
		this.flightName = flightName;
		this.price = price;
		this.flightCode = flightCode;
		this.flightTravelDetails = flightTravelDetails;
	}

	public List<FlightTravelDetails> getFlightTravelDetails() {
		return flightTravelDetails;
	}

	public void setFlightTravelDetails(List<FlightTravelDetails> flight_Time) {
		this.flightTravelDetails = flight_Time;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
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
	
	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flightName=" + flightName + ", price=" + price
				+ ", flightTravelDetails=" + flightTravelDetails + ", flightCode="+ flightCode + " ]";
	}
}
