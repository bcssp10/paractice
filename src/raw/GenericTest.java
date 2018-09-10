package raw;

import java.util.Collection;
import java.util.List;

class Fruit implements Comparable<Fruit>
{
    @Override
    public int compareTo(Fruit o) { return 0; }
}

class Apple extends Fruit{}

public class GenericTest {

	public static void main(String[] args) {
		List<Math> sk =null;
		Collection<Math> s = sk;
		
	}
	
}
