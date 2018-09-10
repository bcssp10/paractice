package security.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.DatatypeConverter;

public class SignatureTest {
	
	private static String message = "image.png";
	private static long time = System.currentTimeMillis();
	private static byte[] messageBytes = message.getBytes();
	private static byte[] timeBytes = ByteBuffer.allocate(Long.BYTES).putLong(time).array();
	private static byte iv = (byte) message.length();
	
	public static void main(String[] args) throws Exception {
		init();
		//verify();
	}
	
	public static void init() throws IOException, NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(timeBytes);
		md.update(messageBytes);
		byte[] hash = md.digest();
		
		ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
		outputStream2.write(hash); // 16 bytes
		outputStream2.write(toCBC(timeBytes)); // 8 bytes
		outputStream2.write(messageBytes); // variable bytes
		byte[] sigBytes= outputStream2.toByteArray();
		outputStream2.close();
		
		System.out.println(new String(hash));
		System.out.println(time+" "+new String(timeBytes));
		System.out.println(new String (messageBytes));
		
		verify(sigBytes);
		System.out.println(new String(new String(Base64.getEncoder().encode(hash)).getBytes(StandardCharsets.US_ASCII)));
//		System.out.println(Arrays.toString(timeBytes));
//		System.out.println(Arrays.toString(sigBytes));
//		System.out.println(new String(sigBytes));
//		System.out.println(new String(Base64.getEncoder().encode(sigBytes)));
//		System.out.println(new String(hash));
//		System.out.println(Base64.getEncoder().encode(hash));
//		System.out.println(DatatypeConverter.printHexBinary(hash));
//		System.out.println(DatatypeConverter.printHexBinary(Base64.getEncoder().encode(hash)));
		
	}
	
	public static void verify(byte[] sigBytes) throws NoSuchAlgorithmException{
		byte hash[] = new byte[16];
		byte time[] = new byte[8];
		byte message[] = new byte[sigBytes.length-24];
		
		System.arraycopy(sigBytes, 0, hash, 0, 16);
		System.arraycopy(sigBytes, 16, time, 0, 8);
		System.arraycopy(sigBytes, 24, message, 0, message.length);
		
		
		
		fromCBC(time, (byte)message.length);
		
		System.out.println(new String(hash));
		System.out.println(((ByteBuffer)ByteBuffer.allocate(Long.BYTES).put(time).flip()).getLong()+" "+ new String(time));
		System.out.println(new String(message));
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(time);
		md.update(message);
		System.out.println(Arrays.equals(hash, md.digest()));
	}

	public static byte[] toCBC(byte[] bytes) {
		bytes[0] ^= iv;

		for(byte b=1; b<bytes.length; b++) 
			bytes[b] ^= bytes[b-1]; 
		
		return bytes;
	}
	
	public static byte[] fromCBC(byte[] bytes, byte iv) {
		
		byte lastCipherByte=bytes[0];
		byte byteHolder;
		for(byte b=1; b<bytes.length; b++) {
			byteHolder = (byte)(bytes[b] ^ lastCipherByte);
			lastCipherByte = bytes[b];
			bytes[b] = byteHolder;
		}
		bytes[0]^=iv;
		return bytes;
	}
	
}
