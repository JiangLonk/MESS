package S048;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mixture {
	public static final int up = 0;
	public static final int right = 1;
	public static final int down = 3;
	public static final int left = 4;
	List<Cell> cells = new ArrayList<Cell>();
	Integer x;
	Integer y;

	public Mixture() {
		generator(x, y);
	}

	public Mixture(Integer diam) {
		generator(diam, diam);
	}

	public Mixture getThis() {
		return this;
	}

	void generator(Integer row, Integer col) {
		this.x = col;
		this.y = row;
		for (Integer i = 1; i <= y; i++) {
			for (Integer j = 1; j <= x; j++) {
				cells.add(new Cell(j, i));
			}
		}
		Integer first2 = S048Utils.random(col * row - 1);
		cells.get(first2).value = 2;
		cells.get(S048Utils.random(col * row - 1, first2)).value = 2;
	}

	void insertNew() {
		List<Cell> listOfZero = cells.stream().filter(cell -> (cell.value == 0)).collect(Collectors.toList());
		if (!listOfZero.isEmpty()) {
			int index;
			if (listOfZero.size() > 1) {
				index = new Random().ints(1, listOfZero.size()).findFirst().getAsInt();
			} else {
				index = 0;
			}
			int newNum = 2;
			if (new Random().nextBoolean()) {
				newNum = 4;
			}
			listOfZero.get(index).value = newNum;
		} else {
			throw new RuntimeException("gg");
		}
	}

	Cell get(Integer x, Integer y) {
		if (x > this.x || y > this.y || x < 1 || y < 1) {
			return null;
		}
		Stream<Cell> filter = cells.stream().filter(cell -> (cell.x == x && cell.y == y));
		Optional<Cell> findFirst = filter.findFirst();
		return findFirst.get();
	}

	/**
	 * 遍历方向: [1-y]; <br>
	 * ┌─────┐ <br>
	 * │↓↓ ↓↓│ <br>
	 * │↓↓ ↓↓│ <br>
	 * └─────┘ <br>
	 */
	void up() {
		String before = toString();
		cells.forEach(new Consumer<Cell>() {
			@Override
			public void accept(Cell cell) {
				cell.up(getThis());
			}
		});
		if (!before.equals(toString())) {
			insertNew();
		}
	}

	/**
	 * 遍历方向 : [y-1]; <br>
	 * ┌─────┐ <br>
	 * │↑↑ ↑↑│ <br>
	 * │↑↑ ↑↑│ <br>
	 * └─────┘ <br>
	 */
	void down() {
		String before = toString();
		cells.sort(S048Utils.reverse);
		cells.forEach(new Consumer<Cell>() {
			@Override
			public void accept(Cell cell) {
				cell.down(getThis());
			}
		});
		cells.sort(S048Utils.compare);
		if (!before.equals(toString())) {
			insertNew();
		}
	}

	/**
	 * 遍历方向: [1-x]; <br>
	 * ┌─────┐ <br>
	 * │→→ →→│ <br>
	 * │→→ →→│ <br>
	 * └─────┘ <br>
	 */
	void left() {
		String before = toString();
		cells.forEach(new Consumer<Cell>() {
			@Override
			public void accept(Cell cell) {
				cell.left(getThis());
			}
		});
		if (!before.equals(toString())) {
			insertNew();
		}
	}

	/**
	 * 遍历方向: [x-1]; <br>
	 * ┌─────┐ <br>
	 * │←← ←←│ <br>
	 * │←← ←←│ <br>
	 * └─────┘ <br>
	 */
	void right() {
		String before = toString();
		cells.sort(S048Utils.reverse);
		cells.forEach(new Consumer<Cell>() {
			@Override
			public void accept(Cell cell) {
				cell.right(getThis());
			}
		});
		cells.sort(S048Utils.compare);
		if (!before.equals(toString())) {
			insertNew();
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("");
		int breakLine = x - 1;
		for (Iterator<Cell> iterator = cells.iterator(); iterator.hasNext();) {
			Cell cell = iterator.next();
			buffer.append(cell.toString() + " ");
			if (breakLine == 0 && iterator.hasNext()) {
				buffer.append("\r\n");
				breakLine = x;
			}
			breakLine--;
		}
		String string = buffer.toString();
		return string;
	}
}
