package erp;

import java.util.ArrayList;

import erp.entity.ItemStock;

public class invTest2 {

	public static void main(String[] args) {
		
		ArrayList<ItemStock> existedStock = new ArrayList<>();
		existedStock.add(new ItemStock("S1","Orange",10.00,5));
		existedStock.add(new ItemStock("S1","Apple",10.00,10));

		ArrayList<ItemStock> updateQty = (ArrayList<ItemStock>) existedStock.clone();
		
		ArrayList<ItemStock> dbStock = new ArrayList<>();
		dbStock.add(new ItemStock("S1","Apple",10.00,7));
		dbStock.add(new ItemStock("S1","Apple",20.00,10));
		dbStock.add(new ItemStock("S1","Orange",10.00,10));

		ArrayList<ItemStock> updateStock = new ArrayList<>();
		updateStock.add(new ItemStock("S1","Apple",20.00,50)); 
		updateStock.add(new ItemStock("S1","Apple",10.00,5));
		
		updateQty.retainAll(updateStock);  // qty updated entries
		existedStock.removeAll(updateStock); // entries to be deleted
		updateStock.removeAll(updateQty); // new entries
		
		System.out.print("\n entries to be deleted | ");
		existedStock.forEach(System.out::println);
		System.out.print("\n updateQty | ");
		updateQty.forEach(System.out::println);
		System.out.print("\n new entities | ");
		updateStock.forEach(System.out::println);
		
	}

}
