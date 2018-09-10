package exceptionTest;

import java.util.HashMap;
import java.util.List;

public class Main {

	public static final String OK = "OKKKK";
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
//		List<Integer> number = null;
//		
//		for (Integer integer : number) {
//			System.out.println(integer);
//		}
		
//		System.out.println(Main.class.getDeclaredField("OK").get(null));
		
		System.out.println(Integer.MAX_VALUE);
		
		HashMap<Integer, Double> map = new HashMap<>();
		map.put(1, map.get(1));
		
		System.out.println(map.get(0));
	}

}
