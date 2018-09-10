package raw;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		long starttime = System.currentTimeMillis();
		for (int i=0; i<1000000000;i++) {
			Map<Short, Double> map = new HashMap<>(4);
			map.put((short)i, (double)i);
		}
		long endtime = System.currentTimeMillis();
		
		System.out.println(endtime - starttime);
	}

}
