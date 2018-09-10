package performance;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		
		int[] form = {1,3,5,7,9,13};
		int[] db = {2,4,6,8};
		
		int []non = new int[6];
		
		boolean found = false;
		
		for (int i=0 ; i <form.length; i++) {
			
			for (int j = 0; j < db.length; j++) {
				if (form[i] == db[j]) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				non[i] = form[i];
			}
			
			found = false;
		}

		System.out.println(Arrays.toString(non));
	}

}
