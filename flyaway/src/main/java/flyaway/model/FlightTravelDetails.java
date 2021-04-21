package flyaway.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightTravelDetails")
public class FlightTravelDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String departureTime;
	private String arrivalTime;
	private String source;
	private String destination;
	
	@ManyToOne//(fetch = FetchType.EAGER)
	//@JoinColumn(name="flightDetails")
	private Flight flight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinaion() {
		return destination;
	}

	public void setDestinaion(String destinaion) {
		this.destination = destinaion;
	}
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public FlightTravelDetails() {
		
	}

	public FlightTravelDetails(int id, String departureTime, String arrivalTime, String source, String destinaion,
			Flight flight) {
		super();
		this.id = id;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.source = source;
		this.destination = destinaion;
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightTravelDetails [id=" + id + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", source=" + source + ", destinaion=" + destination +"]";
	}

	

}
