package erp;

import java.util.ArrayList;
import java.util.List;

import erp.dto.LineItem;
import erp.entity.ItemStock;

public class invTest4 {

	public static void main(String[] args) {

		ArrayList<ItemStock> dbStock = new ArrayList<>();
		dbStock.add(new ItemStock("S1","Apple",10.00,5));
		dbStock.add(new ItemStock("S1","Apple",20.00,10));
		dbStock.add(new ItemStock("S1","Orange",1.00,1));
		dbStock.add(new ItemStock("S1","Orange",2.00,10));
		dbStock.add(new ItemStock("S1","Orange",3.00,11));
		
		ArrayList<ItemStock> negativeQty = new ArrayList<>();
		negativeQty.add(new ItemStock("S1","Orange",20.00,-15));
		negativeQty.add(new ItemStock("S1","Apple",20.00,-14));
		
		ArrayList<ItemStock> deleteStock = new ArrayList<>();
		ArrayList<ItemStock> updateStock = new  ArrayList<>();
		
 		for (ItemStock nstock: negativeQty) {
 			
 			int reqQty = nstock.getQty();
			for (ItemStock stock: dbStock) {
				
				if (stock.getId().getItemId() == nstock.getId().getItemId()) {
					
					reqQty += stock.getQty();
					
					if (reqQty <= 0) {
						deleteStock.add(stock);
					}	
					else {
						stock.setQty(reqQty - stock.getQty());
						updateStock.add(stock);
					}
					
					if (reqQty >= 0)
						break;
					
				}
			}
			
			if (reqQty < 0)
				throw new RuntimeException("onhand quantity = "+Math.abs(nstock.getQty()-reqQty)+", requested to shrink = "+ Math.abs(nstock.getQty()));
		
		}
		
//		dbStock.removeAll(deleteStock);
		
		System.out.println("Delete Items | ");
		deleteStock.stream().forEach(System.out::println);

		System.out.println("Update Items | ");
		updateStock.stream().forEach(System.out::println);
	}

}
