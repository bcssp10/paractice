package security.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class Signature {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		
		//String url = "https://www.cloudinary.com/image/someimage.png";
		
		String url = "someimage.png";
		Long time =System.currentTimeMillis();
		String message = time +"." + url;
		String message2 = (time<<1) +"." + url;
		byte[] data = message.getBytes();
		byte[] hash = null;
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		hash = md.digest(data);
		
		System.out.println(hash.length);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(hash);
		outputStream.write(message2.getBytes());
		byte[] hashedData= outputStream.toByteArray();
		outputStream.close();
		
		System.out.println(new String(hashedData));
		System.out.println(new String(hashedData).indexOf("+"));
		System.out.println(Base64.getEncoder().encodeToString(hashedData));
		//DatatypeConverter.printHexBinary(hashedData).toUpperCase();
		System.out.println(DatatypeConverter.printHexBinary(hashedData));
		System.out.println(DatatypeConverter.printHexBinary(Base64.getEncoder().encode(hashedData)).toUpperCase());
		
		String hiddenURL = DatatypeConverter.printHexBinary(hashedData);
		byte [] reversed = DatatypeConverter.parseHexBinary(hiddenURL);
		System.out.println(Arrays.toString(reversed));
		byte [] reversedHash = new byte[16];
		byte [] reversedData = new byte[reversed.length-16];
		
		System.arraycopy(reversed, 0, reversedHash, 0, 16);
		System.arraycopy(reversed, 16, reversedData, 0, reversed.length-16);
		
		System.out.println(new String(reversedHash));
		System.out.println(new String(reversedData));
		System.out.println(Arrays.equals(reversedHash, md.digest(reversedData)));
		
		
		
//		System.out.println(message);
//		System.out.println(Base64.getEncoder().encodeToString(message.getBytes()));
		
		System.out.println(1<<1);
		
	}
	
}
