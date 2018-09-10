package date.millisecond;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil {

	public static long extractTime(long millis) {
		return millis - extractDate(millis);
	}
	
	public static int calculateNights(long end, long start) {
		Calendar calendar = getCalendar();
		end = extractDate(calendar, end);
		calendar.clear();
		start = extractDate(calendar, start);
		return (int)(end - start)/ 86400000;
	}
	
	public static long extractDate(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
	
	public static long extractDate(Calendar calendar, long millis) {
		calendar.setTimeInMillis(millis);
		return extractDate(calendar);
	}
	
	public static long extractDate(long millis) {
		return extractDate(getCalendar(),millis);
	}
	
	private static Calendar getCalendar() {
		return Calendar.getInstance(TimeZone.getTimeZone("GMT+5:00"));
	}
	
}
