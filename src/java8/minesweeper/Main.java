package java8.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Cell> cells = new ArrayList<Cell>();
		int x = 16;
		int y = 16;
		int mineQty = 32;
		for (int i = 0; i < x * y; i++) {
			if (i == 0) {
				cells.add(new Cell());
			}
		}
	}
}
