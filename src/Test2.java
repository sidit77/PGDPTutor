
public class Test2 {

	static int formula(int x) {
		return 5 * (int)Math.sqrt(x) / x;
	}
	
	static void test1() {
		int result = formula(1);
		if (result == 5)
			System.out.println("test1() passed. 5 == formula(1)");
		else
			System.out.println("test1() FAILED!!! 5 != formula(1)");
	}
	
	static void testMaxInt() {
		int result = formula(Integer.MAX_VALUE);
		if (result == 0)
			System.out.println("test1() passed. 0 == formula(maxint)");
		else
			System.out.println("test1() FAILED!!! 0 != formula(mxint)");
	}
	
	public static void main(String[] arbs) {
		
		test1();
		testMaxInt();
	}
	
}
