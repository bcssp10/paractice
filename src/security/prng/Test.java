package security.prng;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		System.out.println(Integer.toBinaryString(~(-2222444)+1));
		System.out.println(~(2222444)+1);
		System.out.println(-2222444);
		
		//long aliveTime = System.currentTimeMillis();
		long aliveTime = 22222222222222222L;//868083590805602724
		System.out.println("Time: " + aliveTime);
		
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(aliveTime);
		System.out.println(Arrays.toString(buffer.array()));
		byte[] barray = buffer.array();
		
		byte iv = 12;
		System.out.println("a ^ b = "+barray[0]+" ^ "+iv+" = "+(barray[0] ^ iv));
		barray[0] ^= iv;
		for(byte b=1; b<barray.length; b++) {
			System.out.println("a ^ b = "+barray[b]+" ^ "+barray[b-1]+" = "+(barray[b] ^ barray[b-1]));
			barray[b] ^= barray[b-1]; 
		}
		System.out.println(Arrays.toString(barray));
		System.out.println("c ^ b = "+barray[0]+" ^ "+iv+" = "+(barray[0] ^ iv));

		ByteBuffer buffer3 = ByteBuffer.allocate(Long.BYTES);
		buffer3.put(barray);
		buffer3.flip();//need flip 
	    System.out.println(buffer3.getLong());

		
		byte temp=barray[0];
		byte temp2;
		for(byte b=1; b<barray.length; b++) {
			System.out.println("c ^ b = "+barray[b]+" ^ "+barray[b-1]+" = "+(barray[b] ^ barray[b-1]));
			temp2 = (byte)(barray[b] ^ temp); // 12 ^ 12 = 0
			temp = barray[b]; // 12
			barray[b] = temp2; // 0
		}
		barray[0] ^= iv;
		System.out.println(Arrays.toString(barray));
		
		
		ByteBuffer buffer2 = ByteBuffer.allocate(Long.BYTES);
		buffer2.put(barray);
		buffer2.flip();//need flip 
	    System.out.println(buffer2.getLong());
		
	}

	private static void longToByteArray(long l, byte[] b) {
		b[7] = (byte) (l);
		l >>>= 8;
		b[6] = (byte) (l);
		l >>>= 8;
		b[5] = (byte) (l);
		l >>>= 8;
		b[4] = (byte) (l);
		l >>>= 8;
		b[3] = (byte) (l);
		l >>>= 8;
		b[2] = (byte) (l);
		l >>>= 8;
		b[1] = (byte) (l);
		l >>>= 8;
		b[0] = (byte) (l);
	}

}
