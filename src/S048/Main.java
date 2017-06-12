package S048;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Mixture mixture = new Mixture(5);
		System.out.println("生成:");
		System.out.println(mixture.toString());
		// System.out.println("倒序:");
		// mixture.cells.sort(S048Utils.reverse);
		// System.out.println(mixture.toString());
		// System.out.println("正序:");
		// mixture.cells.sort(S048Utils.compare);
		// System.out.println(mixture.toString());
		// System.out.println("左划:");
		// mixture.left();
		// System.out.println(mixture.toString());
		// for (int i = 0; i < 100; i++) {
		// System.out.println("上划:");
		// mixture.up();
		// System.out.println(mixture.toString());
		// }
		// for (int i = 0; i < 100; i++) {
		// System.out.println("下划:");
		// mixture.down();
		// System.out.println(mixture.toString());
		// }
		// System.out.println("右划:");
		// mixture.right();
		// System.out.println(mixture.toString());
		// new Random().ints(1, 4).forEach(i->System.out.println(i));
		do {
			String before = mixture.toString();
			String action = "";
			switch (new Random().ints(1, 4).findFirst().getAsInt()) {
			case 1:
				action = ("↑");
				mixture.up();
				break;
			case 2:
				action = ("→");
				mixture.right();
				break;
			case 3:
				action = ("↓");
				mixture.down();
				break;
			default:
				action = ("←");
				mixture.left();
				break;
			}
			if (!before.equals(mixture.toString())) {
				System.out.println(action);
				System.out.println(mixture.toString());
				System.out.println();
			}
		} while (true);
	}
}
