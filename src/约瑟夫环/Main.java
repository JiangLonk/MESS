package Լɪ��;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		/* ����n/m */
		int n = 10;
		int m = 3;
		/* �����1-M���� */
		int toM = 1;
		/* ���ʣ����� */
		int number;
		/* ���ɼ��� */
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		Integer current;
		/* ������Ԫ����������1ʱ: */
		do {
			/* ����ǰ����Ԫ������������ */
			Iterator<Integer> it = list.iterator();
			do {
				/* ���� */
				current = it.next();
				number = current;
				/* 1-mѭ������ */
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
