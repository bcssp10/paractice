package erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import erp.entity.ItemStock;

public class Test {

	public static void main(String[] args) {
		
		long start = System.nanoTime();
		
		ArrayList<ItemStock> formStock = new ArrayList<>();
		formStock.add(new ItemStock("S1","Orange",10.00,5));
		formStock.add(new ItemStock("S1","Apple",10.00,5));
		
		ArrayList<ItemStock> dbFormStock = new ArrayList<>();
		dbFormStock.add(new ItemStock("S1","Orange",10.00,5));
		dbFormStock.add(new ItemStock("S1","OKO",10.00,10));
		
		ArrayList<ItemStock> dbStock = new ArrayList<>();
		dbStock.add(new ItemStock("S1","Orange",10.00,4));
		dbStock.add(new ItemStock("S1","OKO",10.00,10));
		
		HashMap<ItemStock,Integer> map = new HashMap<>();
		for (ItemStock is : dbFormStock)
			map.put(is, map.getOrDefault(is, 0) - is.getQty());
		
		for (ItemStock is : formStock)
			map.put(is, map.getOrDefault(is, 0) + is.getQty());
		
//		for (ItemStock is : dbStock)
//			if (map.containsKey(is))
//				map.put(is, map.get(is) + is.getQty());
		
//		for (Map.Entry<ItemStock,Integer> entry : map.entrySet()) {
//			ItemStock is = entry.getKey();
//			is.setQty(entry.getValue());
//			
//			if (is.getQty() < 0) {
//				if (getQty(is,dbStock) + is.getQty() < 0)
//					throw new RuntimeException("HAHAHHA "+getQty(is,dbStock));
//			}
//			
//		}
		
		
//		for (ItemStock is : dbStock)
//			if (map.getOrDefault(is, 0) + is.getQty()  < 0)
//				throw new RuntimeException("kok") ;
		
		
		
		
		ArrayList<ItemStock> add = new ArrayList<>();
		ArrayList<ItemStock> update = new ArrayList<>();
		ArrayList<ItemStock> delete = new ArrayList<>();
		
		for (Map.Entry<ItemStock,Integer> entry : map.entrySet()) {
			ItemStock is = entry.getKey();
			is.setQty(entry.getValue());
			
			if( !dbStock.contains(is) ) {
				if (is.getQty() < 0 )
					throw new RuntimeException("YO LO IV");
				if (is.getQty() != 0)
					add.add(is);
			}else {
				int newQty = is.getQty() + dbStock.get(dbStock.indexOf(is)).getQty();
				
				if (newQty == 0) {
					delete.add(is);
				} else if (newQty > 0) {
					if (is.getQty() > 0)
					update.add(is);
				} else {
					throw new RuntimeException("onhand qty = " + Math.abs(is.getQty() - newQty) + ", requested to shrink = "+Math.abs(is.getQty())+" for itemId = "+ is.getId().getItemId());
				}
			}
			
		}
		
		System.out.println("ADD ITEMS | ");
		add.forEach(System.out::println);
		
		System.out.println("UPDATE ITEMS | ");
		update.forEach(System.out::println);
		
		System.out.println("DELETE ITEMS | ");
		delete.forEach(System.out::println);
//		
//		
//		System.out.println("\n "+(System.nanoTime() - start));
		
//		printMap(map);
		
	}

	static void printMap(Map<ItemStock,Integer> map){
		for (Map.Entry<ItemStock,Integer> entry : map.entrySet())
				System.out.println("KEY = "+entry.getKey()+" | VALUE = "+entry.getValue());
	}
	
	static ArrayList<ItemStock> toStockList(Map<ItemStock,Integer> map){
		ArrayList<ItemStock> list = new ArrayList<>();
		for (Map.Entry<ItemStock,Integer> entry : map.entrySet())
			list.add(new ItemStock(entry.getKey().getId().getStockId(), entry.getKey().getId().getItemId(), entry.getKey().getId().getRate(), entry.getKey().getQty()));
	
		return list;
	}

	public static int getQty(ItemStock is, List<ItemStock> list) {
		int idx = list.indexOf(is);
		if (idx < 0)
			return 0;
			
		return list.get(idx).getQty();
	}
	
}
