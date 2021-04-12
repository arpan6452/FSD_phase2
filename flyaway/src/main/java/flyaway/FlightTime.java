package flyaway;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightTime")
public class FlightTime {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date dateofTravel;
	
	@ManyToOne
	private Flight flight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateofTravel() {
		return dateofTravel;
	}

	public void setDateofTravel(Date dateofTravel) {
		this.dateofTravel = dateofTravel;
	}
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightTime [id=" + id + ", dateofTravel=" + dateofTravel + "]";
	}

}
