package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

	static List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 }));

	public static void main(String[] args) {
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if (integer % 2 == 1) {
				iterator.remove();
			} else {
				System.out.println(integer);
			}

		}
		System.out.println(list);
	}

}
