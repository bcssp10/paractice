package security.prng;

// Pseudo Random Number Generator
public class Prng {

	public static void main(String[] args) {
		double a=35, b=98;
		
		for(int i=0; i<20; i++)
			System.out.println((a*System.nanoTime()+b)%Math.pow(2, 64)%26);
		
	}

}
