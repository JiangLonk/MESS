package 兔子;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 兔子厂 {
	List<兔子> 兔子s = new ArrayList<兔子>();

	public List<兔子> get兔子s() {
		return 兔子s;
	}

	public void set兔子s(List<兔子> 兔子s) {
		this.兔子s = 兔子s;
	}

	public 兔子厂() {
		super();
		兔子s.add(new 兔子());
	}

	public void 统计() {
		int 一岁 = 0;
		int 二岁 = 0;
		int 成年 = 0;
		for (Iterator<兔子> iterator = 兔子s.iterator(); iterator.hasNext();) {
			兔子 兔子 = iterator.next();
			if (兔子.get年龄() == 1) {
				一岁++;
			} else if (兔子.get年龄() == 2) {
				二岁++;
			} else {
				成年++;
			}
			兔子.成长();
		}
		System.out.println("\t一岁:" + 一岁 + "\t二岁:" + 二岁 + "\t成年:" + 成年 + "\t共:" + (一岁 + 二岁 + 成年));
		System.out.println();
	}

	public void 结算() {
		List<兔子> 前月兔子s = new ArrayList<兔子>(get兔子s());
		for (Iterator<兔子> iterator = 前月兔子s.iterator(); iterator.hasNext();) {
			兔子 兔子 = iterator.next();
			兔子 兔儿子 = 兔子.生兔子();
			if (兔儿子 != null) {
				兔子s.add(兔儿子);
			}
		}
	}
}
