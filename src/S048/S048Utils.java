package S048;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class S048Utils {

	static Comparator<Cell> compare = new Comparator<Cell>() {
		@Override
		public int compare(Cell self, Cell other) {
			if (self.y > other.y) {
				return 1;
			} else if (self.y < other.y) {
				return -1;
			} else {
				if (self.x < other.x) {
					return -1;
				} else if (self.x > other.x) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	};

	static Comparator<Cell> reverse = new Comparator<Cell>() {
		@Override
		public int compare(Cell self, Cell other) {
			if (self.y > other.y) {
				return -1;
			} else if (self.y < other.y) {
				return 1;
			} else {
				if (self.x < other.x) {
					return 1;
				} else if (self.x > other.x) {
					return -1;
				} else {
					return 0;
				}
			}
		}

	};

	static int random(Integer square, Integer... ignores) {
		int random = random(square);
		while (ignores != null && Arrays.asList(ignores).contains(random)) {
			random = random(square);
		}
		return random;
	}

	static int random(Integer square) {
		return new Random().ints(1, square + 1).findFirst().getAsInt();
	}
}
