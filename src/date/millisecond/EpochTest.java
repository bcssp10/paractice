package date.millisecond;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EpochTest {
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		
		Calendar cc = Calendar.getInstance();
		
		cc.set(Calendar.YEAR, 2018);
		cc.set(Calendar.MONTH, 1);
		cc.set(Calendar.DAY_OF_MONTH, 12);
		cc.set(Calendar.HOUR_OF_DAY, 21);
		cc.set(Calendar.MINUTE, 35);
		
		System.out.println(cc.getTimeZone() + "" + cc.getTimeInMillis());
		
		System.exit(0);

		while(true) {
			//System.out.println(new Date().getTime());
			//System.out.println(System.currentTimeMillis());
			//System.out.println(new Date(Instant.now().toEpochMilli()-(24*60*60*1000)));
			System.out.println(ZonedDateTime.now(ZoneId.of("America/Adak")).minusDays(0).toEpochSecond());
			
			ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(1518418176896L), ZoneId.of("Asia/Karachi")).minusDays(1);
			ZonedDateTime zdt2 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(1518418176896L), ZoneId.of("America/Adak")).minusDays(1);
			System.out.println(zdt.toEpochSecond() +" "+ zdt2.toEpochSecond());;
			Thread.sleep(1000);
			
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(1518418176896L);
			c.setTimeZone(TimeZone.getTimeZone("America/Adak"));
//			c.set(Calendar.HOUR_OF_DAY, 0);
//			c.set(Calendar.MINUTE, 0);
//			c.set(Calendar.SECOND, 0);
//			c.set(Calendar.MILLISECOND, 0); 1518418176896
			long start = c.getTimeInMillis();
			
			System.out.println(start);
			
		}
//		Date date = new Date(1518418176896L); 1518429600000 1518375600000
//		Date date = new Date(1518367776000L);
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		formatter.setTimeZone(TimeZone.getTimeZone("GMT-5")); 
//		System.out.println(formatter.format(date));
//		
//		System.out.println(formatter.parse("2018-02-12 02:49:36").getTime());
//		
//		//1518418176896 2018-02-11 11:49:36
//		//1518291537829
//		
	}

}
