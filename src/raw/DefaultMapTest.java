package raw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultMapTest {

	public static void main(String[] args) {
		
		List<Integer> s = Arrays.asList(1,2,3,4,5,6);
		
		s.stream().forEach((i) -> {
			throw new RuntimeException("OMG");
		});
		
	}

}
