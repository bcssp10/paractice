package erp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import erp.entity.ItemStock;

public class PaymentTest2 {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		Collections.addAll(integers, 1,2,3,4,5,7);
		
		List<Integer> newIntegers = new ArrayList<>(integers);
		
		List<Integer> dbIntegers = new ArrayList<>();
		Collections.addAll(dbIntegers, 1,2,3,4,5,6);
//		dbIntegers.removeAll(integers);
		
//		newIntegers.removeAll(dbIntegers);
//		dbIntegers.removeAll(integers);
		
		integers.addAll(dbIntegers);
		
		integers.forEach(System.out::println);
//		newIntegers.forEach(System.out::println);
//		dbIntegers.forEach(System.out::println);
	}

}
