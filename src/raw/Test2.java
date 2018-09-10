package raw;

import java.util.HashMap;

public class Test2 {

	public static void main(String[] args) {
		Guest[] guests = new Guest[4];
		guests[0] = new Guest(1L,"ABC");
		guests[1] = new Guest(2L,"ABD");
		guests[2] = new Guest(3L,"ABC");
		guests[3] = new Guest(4L,"ABD");
		
//		/** Solution 1 puropsed */		
//		HashMap<String, Guest> map = new HashMap<>();
//
//		for (int i = guests.length - 1 ;i>-1; i--) {
//			map.put(guests[i].source,guests[i]);
//		}	
//
//		for (int i = guests.length - 1 ;i>-1; i--) {
//			System.out.println(guests[i].id + " " +map.get(guests[i].source).id + " " +map.get(guests[i].source).source);
//		}	

		int[] x = new int[guests.length];
		
		/** Solution 2 purposing */
		for (int i = guests.length - 1 ;i>0; i--) 
			for (int j = i-1; j > -1 ; j-- )
			if (guests[i].source.equals(guests[j].source)) {
				guests[i] = guests[j];
				x[i] = -1;
			}

		for (int i = 0; i < guests.length; i++)
			if (x[i] != -1) {
				guests[i].yolo = "yolo";
//				guests[i].id =  guests[i].id + 1;
			}
		
		for (int i = 0; i < guests.length; i++)
				System.out.println(guests[i]);
		
//			for (int i=0;i < guests.length;i++)
//			System.out.println(guests[i].id + " " + guests[i].source);
		
//		map.put(guests[0].source, guests[0]);
//		map.put(guests[1].source, guests[1]);
//		map.put(guests[2].source, guests[2]);
//		
//		map.forEach((k,v) -> System.out.println(k+" "+v.id));
	}
	
}


class Guest{

	public Long id;
	public String source;
	public String yolo;
	
	public Guest(Long id, String source) {
		this.id = id;
		this.source = source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
	
	
}