package date.millisecond;

import java.util.Calendar;
import java.util.TimeZone;

public class unixTimeStamp {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:00"));
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long start = calendar.getTimeInMillis();
		calendar.add(Calendar.DAY_OF_YEAR,1);
		long end = (24*60*60*1000 - 0);
		
	//	calendar.res
		
		System.out.println(start+" "+(start+end)+" "+calendar.getTimeInMillis());
	}

}
