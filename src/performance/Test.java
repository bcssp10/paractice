package performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
//		HashSet<Short> set = new HashSet<>(Arrays.asList(array));
//		new ArrayList<>(set);
		long start = System.currentTimeMillis();
		
		for (int x = 0 ; x < 10; x++) {
			 short[] array = new short[100000];
			    for (int i=0; i<100000; i++){
			    	short n = (short)(Math.random()*1000 + 1);
			    	array[i] = n;
			    }
	
//		short array[] = {1,2,2,3,4,5,4,5};
//		for (int i = array.length - 1; i > 0; i--) {
//			for (int j = i - 1; j > -1; j--) {
//				if (array[i] == array[j]) {
//					array[i] = -1;
//					break;
//				}
//			}
//		}	
			    HashSet<Short> set = new HashSet<>();
			    for (Short ar : array)
			    	set.add(ar);
//				new ArrayList<>(set);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start));
//		 short[] list = new short[20];
//		    for (short i=0; i<10; i++){
//		    	short n = (short)(Math.random()*1000 + 1);
//		        list[i] = n;
//		    }
	}

}
