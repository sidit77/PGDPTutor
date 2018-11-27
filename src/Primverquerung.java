
public class Primverquerung {

	private static boolean isPrim(int x) {
		if (x == 2)
			return true;
		if (x % 2 == 0)
			return false;
		for (int i = 3; i * i <= x; i += 2)
			if (x % i == 0)
				return false;
		return true;
	}

	public static int querPrim(int n) {
		int result = 0;
		for (int i = 2; i < n; i++) {
			if (isPrim(i)) {
				int quersumme = 0;
				for (int z = i; z != 0; z /= 10)
					quersumme += z % 10;
				if (quersumme % 2 == 0)
					result += i;
			}
		}
		return result;
	}

	private boolean isSmaller(int a, int b) {
		return a < b;
	}
	
	public static void main(String[] args) {
		System.out.println(querPrim(25));
		System.out.println(querPrim(89));
		System.out.println(querPrim(122));
		System.out.println(querPrim(5424));
		System.out.println(querPrim(0));
		System.out.println(querPrim(-1));
	}

}
