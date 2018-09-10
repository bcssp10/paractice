package raw;


public class Test {

	public static void main(String[] args) {
		String res = "pos";
		String dbRes = "CHECKED_IN";
		if((dbRes.equals("CHECKED_IN") && !res.equals("CHECKED_IN")) || (!res.equals("HOLD") && !res.equals("CHECKED_IN")))
			throw new RuntimeException("invalid status");
	}

}
