package date.millisecond;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Nights {

	public static void main(String[] args) {
		
		long checkoutTime = 14*60*60*1000L;
		long sysdate = 1518894000000L; 
		long currentTime = DateUtil.extractTime(System.currentTimeMillis());

		System.out.println(sysdate + currentTime - checkoutTime);
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2018, Calendar.FEBRUARY, 17);
//		
//		long sysdate = cal.getTimeInMillis();
//		
//		cal.set(1970, Calendar.JANUARY, 1);
//		cal.set(Calendar.HOUR_OF_DAY,14);
//		cal.set(Calendar.MINUTE,0);
//		cal.set(Calendar.SECOND,0);
//		cal.set(Calendar.MILLISECOND,0);
//		
//		cal.set
//		
//		long checkinTime = cal.getTimeInMillis();
//		long checkoutTime = checkinTime - 2*60*60*1000;
//		
//		System.out.println(new  Date(checkinTime)+" - "+new Date(checkoutTime));
		
		
	}
	
}
