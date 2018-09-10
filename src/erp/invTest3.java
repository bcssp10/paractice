package erp;

import java.util.ArrayList;

import erp.entity.ItemStock;

public class invTest3 {

	public static void main(String[] args) {
		
		long start = System.nanoTime();
		
		ArrayList<ItemStock> existingStock = new ArrayList<>();
		existingStock.add(new ItemStock("S1","Mango",10.00,6));
//		existingStock.add(new ItemStock("S1","OKO",10.00,10));
		
		ArrayList<ItemStock> newStock = new ArrayList<>();
		newStock.add(new ItemStock("S1","Mango",10.00,8));
		newStock.add(new ItemStock("S2","Apple",20.00,50)); 
		newStock.add(new ItemStock("S2","Apple",10.00,5));
		newStock.add(new ItemStock("S2","OKO",10.00,11));
		
		ArrayList<ItemStock> dbStock = new ArrayList<>();
//		dbStock.add(new ItemStock("S1","Apple",10.00,5));
//		dbStock.add(new ItemStock("S1","Apple",20.00,10));
		dbStock.add(new ItemStock("S1","Orange",10.00,10));
		dbStock.add(new ItemStock("S1","Orange",30.00,10));
		dbStock.add(new ItemStock("S1","Orange",20.00,10));
		dbStock.add(new ItemStock("S1","Mango",10.00,4));
		dbStock.add(new ItemStock("S2","Mango",10.00,6));
		dbStock.add(new ItemStock("S1","Banana",10.00,10));
		
		ArrayList<ItemStock> newLineStock = (ArrayList<ItemStock>) newStock.clone();
		newLineStock.removeAll(existingStock); // new line items
		newStock.removeAll(newLineStock); // existing line items

		for (ItemStock existed : existingStock) {
			int qty = -existed.getQty();
			
			for (ItemStock newUpdated : newStock) {
				if (existed.equals(newUpdated)) {
					qty = newUpdated.getQty() + qty;
					break;
				}
			}
			
			existed.setQty(qty);
		}


		ArrayList<ItemStock> deleteItems = new ArrayList<>();
		boolean notfound = true;
		for (ItemStock existed : existingStock) {

			for (ItemStock db : dbStock) {
					if (existed.equals(db)) {
						if (db.getQty() + existed.getQty() == 0)
							deleteItems.add(existed);
						else if (db.getQty() + existed.getQty() < 0)
							throw new RuntimeException("\n Minimum quantity allowed for "+existed.getId().getItemId()+" is "+-(db.getQty() + existed.getQty())+"\n"+db);
						notfound = false;
						break;
					}
			}
			if (notfound) {
				if (existed.getQty() < 0)
					throw new RuntimeException("yolo invalid inventory");

				else if (existed.getQty() != 0)
					newLineStock.add(existed);
			}	
			
			notfound = true;
		}	

		ArrayList<ItemStock> dbExistedStock = (ArrayList<ItemStock>) newLineStock.clone();
		
		dbStock.retainAll(newLineStock); // for performance if dbStock contains some unnecessary entries
		newLineStock.removeAll(dbStock); // new line item that doesn't pre exists in database
		dbExistedStock.removeAll(newLineStock); // new line items that do exists in database
		existingStock.removeAll(deleteItems); // removing line items that do exists in database but are going to be deleted
		existingStock.removeAll(newLineStock); // removing line item that doesn't pre exists in database
		existingStock.addAll(dbExistedStock); // merging pre existing line items with already existing stock which came from new stock list

//		
//		System.out.println("DB STOCK | ");
//		dbExistedStock.stream().forEach(System.out::println);

		System.out.println("NEW ITEMS | ");
		newLineStock.stream().forEach(System.out::println);

//		System.out.println("NEW UPDATE STOCK | ");
//		newUpdateStock.stream().forEach(System.out::println);
//		updateQtyStock.stream().forEach(System.out::println);
		
		System.out.println("EXISTING  ITEMS | ");
		existingStock.stream().forEach(System.out::println);
//		updateQtyStock.stream().forEach(System.out::println);
		
		System.out.println("DELETE  ITEMS | ");
		deleteItems.stream().forEach(System.out::println);
		
		System.out.println("\n "+(System.nanoTime() - start));
	}
	
}
