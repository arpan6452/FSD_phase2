package flyaway.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	public static void main(String[] args) {
		Util util = new Util();
		util.dateTimeDifference("2021-04-05T08:30", "2021-04-05T05:30");
	}
	public String dateTimeDifference(String date1, String date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		date1= date1.concat(":00").replace("T", " ");
		date2= date2.concat(":00").replace("T", " ");

		LocalDateTime dateTime1 = LocalDateTime.parse(date1, formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse(date2, formatter);

		long diffInMinutes = java.time.Duration.between(dateTime2, dateTime1).toMinutes();
		long inHours = diffInMinutes/60;
		long inMinutes = diffInMinutes%60;
		
		return inHours +"hr "+ inMinutes+"min";
	}
}
