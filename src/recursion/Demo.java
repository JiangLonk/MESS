package recursion;

import java.math.BigInteger;

public class Demo {
//	static BigInteger i = new BigInteger("1");
	static long i = 0l;
	public static void main(String[] args) {
		long start, end;
		System.out.println("普通递归 n = 40");
		start = System.currentTimeMillis();
		System.out.println(fibNormalRec(40));
		end = System.currentTimeMillis();
		System.out.println("\t>>" + ((double) (end - start) / 1000) + " s");
		System.out.println("方法共被调用:" + i + "次");
//		i = new BigInteger("0");
		i = 0l;
//		i = 0l;
		System.out.println();
		
		System.out.println("尾递归 n = 5000");
		start = System.currentTimeMillis();
		System.out.println(fibRailRec(5000));
		end = System.currentTimeMillis();
		System.out.println("\t>>" + ((double) (end - start) / 1000) + " s");
		System.out.println("方法共被调用:" + i + "次");
//		i = new BigInteger("0");
		i = 0l;
		System.out.println();
		
		System.out.println("迭代 n = 5000");
		start = System.currentTimeMillis();
		System.out.println(fibNoRec(5000));
		end = System.currentTimeMillis();
		System.out.println("\t>>" + ((double) (end - start) / 1000) + " s");
		System.out.println();
	}

	// 普通递归
	public static BigInteger fibNormalRec(int n) {
//		i = i.add(new BigInteger("1"));
		i++;
		if (n <= 2)
			return new BigInteger("1");
		else
			return fibNormalRec(n - 1).add(fibNormalRec(n - 2));
	}

	/**
	 * 尾调用的重要性在于它可以不在调用栈上面添加一个新的堆栈帧——而是更新它，如同迭代一般。尾递归因而具有两个特征：
	 * 调用自身函数(Self-called)；
	 * 计算仅占用常量栈空间(Stack Space)。
	 * 而形式上只要是最后一个return语句返回的是一个完整函数，它就是尾递归。
	 * @param n 下标
	 * @param first n=1
	 * @param second n=2
	 * @return
	 */
	public static BigInteger fibRailRec(int n, BigInteger first, BigInteger second) {
//		i = i.add(new BigInteger("1"));
		i++;
		if (n == 1)
			return first;
		if (n == 2)
			return second;
		return fibRailRec(n - 1, second, second.add(first));
	}

	public static BigInteger fibRailRec(int n) {
		return fibRailRec(n, new BigInteger("1"), new BigInteger("1"));
	}

	// 迭代
	public static long fibNoRec(int n) {
		if (n <= 2)
			return 1;
		int x = 1, y = 1, tmpY = 0;
		for (int i = 0; i < n - 2; i++) {
			tmpY = y;
			y = x + y;
			x = tmpY;
		}
		return y;
	}
}
