package erp;

import java.util.ArrayList;
import java.util.List;

import erp.entity.ItemStock;

public class invTest1 {

	public static void main(String[] args) {
		
		List<ItemStock> dbStock = new ArrayList<>();
		dbStock.add(new ItemStock("S1","Apple",10.00,5));
		dbStock.add(new ItemStock("S1","Apple",20.00,10));
		dbStock.add(new ItemStock("S1","Orange",10.00,10));

		ArrayList<ItemStock> newStock = new ArrayList<>();
		newStock.add(new ItemStock("S1","Apple",20.00,50));
		newStock.add(new ItemStock("S1","Apple",10.00,10));
		
		ArrayList<ItemStock> clone = (ArrayList<ItemStock>) newStock.clone();
		dbStock.retainAll(newStock);
		newStock.removeAll(dbStock);
		clone.removeAll(newStock);
		
		System.out.print("NEW STOCK | ");
		newStock.forEach(System.out::println);
		System.out.println();
		System.out.print("DB STOCK | ");
		dbStock.forEach(System.out::println);
		System.out.println();
		System.out.print("CLONE STOCK | ");
		clone.forEach(System.out::println);
	}

}
