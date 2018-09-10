package date.millisecond;

import java.util.Date;

public class DateTests {

	public static void main(String args[]) {
		
		long datemillis = DateUtil.extractDate(System.currentTimeMillis());
		
		System.out.println(new Date(datemillis) + " " + datemillis);
		
	}
	
}
