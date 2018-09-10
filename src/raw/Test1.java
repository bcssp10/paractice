package raw;

import java.util.stream.IntStream;

public class Test1 {

	public static void main(String[] args) {
		
		String [] strings = {"","",null};
		long start = System.currentTimeMillis();
		int x = 0;
//		x = IntStream.range(0, strings.length).filter(i -> strings[i] == null).findFirst().orElse(0);
		
		long end = System.currentTimeMillis();
		System.out.println(findFirstNonNullIdx(strings)+" "+(end-start));
	}

	public static <T> int findFirstNonNullIdx(T[] array) {
		for (int i = 0; i < array.length; i++) 
			if (array[i] == null)
				return i;
		
		return 0;
	}
}
