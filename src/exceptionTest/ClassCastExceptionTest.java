package exceptionTest;

public class ClassCastExceptionTest {

	public static void main(String[] args) {
		int[] i = {0,1,2};
		Object a = i;
		Object b = (Integer[])a;
	}
	
}
