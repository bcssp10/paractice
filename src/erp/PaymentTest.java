package erp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import erp.entity.ItemStock;

public class PaymentTest {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		Collections.addAll(integers, 1,2,2,2,3,4,5,6,7,7,8);
//		integers.forEach(System.out::println);
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		for (Integer num: integers) {
			
			if(map.get(num) == null) {
				map.put(num,new ArrayList<Integer>());
			}
				
			map.get(num).add(num);
			
		}
		
		for(Entry<Integer, List<Integer>> pair : map.entrySet())
			System.out.println(pair.getValue());;
			
			
			ArrayList<ItemStock> dbStock = new ArrayList<>();
			
			dbStock.add(new ItemStock("S1","Apple",10.00,10));
			dbStock.add(new ItemStock("S1","Apple",10.00,10));
			
			System.out.println(dbStock.contains(new ItemStock("S1","Apple",10.00,0)));
			dbStock.forEach(System.out::println);
	}

}
