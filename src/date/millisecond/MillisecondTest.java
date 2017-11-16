package date.millisecond;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class MillisecondTest {

	public static void main(String[] args) {
		
		long date = System.currentTimeMillis(); // current date
		long twoDaysLater = date + (2*24*60*60*1000); // 2 days later
		long twoPoint5DaysLater = (long) (date + (2.5*24*60*60*1000)); // 2 days 12 hours later
		long twoDays12HoursLater = date + ((2*24 + 12)*60*60*1000); // 2 days 12 hours later
		
		printDateTime(date);
		printDateTime(twoDaysLater);
		printDateTime(twoPoint5DaysLater);
		printDateTime(twoDays12HoursLater);
		
	}
	
	private static void printDateTime(long epoch) {
		System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.systemDefault()));
	}

	/*
	 
	 [ Calculating time in epoch examples ] 
	
	 Q) calculate epoch time after 2 days 7 hours
	 
	 A) 1st Method (Recommended) // calculate in hours
	 
	  	1 hour in millis = 60*60*1000
	 	2 days 7 hours = (24*2) + 7
	 	
	 	2 days 7 hours in millis = 2 days 7 hours * 1 hour in millis
	 	2 days 7 hours in millis = ((24*2) + 7) * 60*60*1000
	 	
	 	DONE!
	 	
	 	Alternate Method (Not Recommended) // calculate in hours
	 	
	 	1 day = 24 hours
	 	1 hour = 1/24 day
	 	2 days 7 hours = (24*2) + 7 = 55
	 	
	 	1 hour *  2 days 7 hours = 1/24 day * 2 days 7 hours
	 	time in days			 = 1/24 day * 55
	 	time in days			 = 55/24 day 
	 	
	 	2 days 7 hours in millis = ( 55/24*24*60*60*1000 )
	 	DONE!
	 	
	 */
	
}
