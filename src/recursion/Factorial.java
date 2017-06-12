package recursion;

public class Factorial {
	static int count = 0;

	public static void main(String[] args) {
		System.out.println(factorial(32));
		System.out.println(count);
		count = 0;
		System.out.println(factorialSum(100));
		System.out.println(count);
		int count2 = 0;
		long sum = 0;
		for (int i = 1; i < 101; i++) {
			count2 ++;
			sum += factorial(i);
		}
		System.out.println(sum);
		System.out.println(count2);
	}

	static long factorial(long n) {
		count++;
		if (n == 1) {
			return 1;
		} else {
			long pre = factorial(n - 1);
			return pre * n;
		}
	}

	static long factorialSum(long n) {
		count++;
		if (n == 1) {
			return 1;
		} else {
			return factorialSum(n - 1) + factorial(n);
		}
	}

}
