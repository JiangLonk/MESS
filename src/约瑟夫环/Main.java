package 约瑟夫环;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		/* 输入n/m */
		int n = 10;
		int m = 3;
		/* 输入从1-M计数 */
		int toM = 1;
		/* 最后剩余的数 */
		int number;
		/* 生成集合 */
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		Integer current;
		/* 当集合元素数量大于1时: */
		do {
			/* 将当前集合元素数量做迭代 */
			Iterator<Integer> it = list.iterator();
			do {
				/* 迭代 */
				current = it.next();
				number = current;
				/* 1-m循环计数 */
				if (toM == m) {
					toM = 1;
					it.remove();
				} else {
					toM++;
				}
			} while (it.hasNext());
		} while (list.size() > 1);
		System.out.println(number);
	}
}
