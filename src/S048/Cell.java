package S048;

public class Cell {
	Integer x;
	Integer y;
	long value;

	public Cell() {

	}

	public Cell(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	void move(Mixture mixture, int type) {
		int nextX = this.x;
		int nextY = this.y;
		boolean boundExp;
		Cell nextCell;
		do {
			switch (type) {
			case Mixture.up:
				nextY++;
				boundExp = nextY <= mixture.y;
				break;
			case Mixture.right:
				nextX--;
				boundExp = nextX >= 1;
				break;
			case Mixture.down:
				nextY--;
				boundExp = nextY >= 1;
				break;
			default:
				nextX++;
				boundExp = nextX <= mixture.x;
				break;
			}
			nextCell = mixture.get(nextX, nextY);
			if (nextCell != null && nextCell.value != 0) {
				if (this.value == 0) {
					this.value += nextCell.value;
					nextCell.value = 0;
					this.move(mixture, type);
				} else if (nextCell.value == this.value) {
					this.value += nextCell.value;
					nextCell.value = 0;
				}
				break;
			}
		} while (boundExp);
	}

	void up(Mixture mixture) {
		move(mixture, Mixture.up);
		// Integer nextX = this.x;
		// Integer nextY = this.y + 1;
		// Cell nextCell;
		// while (nextY <= mixture.y) {
		// nextCell = mixture.get(nextX, nextY);
		// if (nextCell != null && nextCell.value != 0) {
		// if (this.value == 0) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// this.up(mixture);
		// } else if (nextCell.value == this.value) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// }
		// break;
		// } else {
		// nextY++;
		// }
		// }
	}

	void down(Mixture mixture) {
		move(mixture, Mixture.down);
		// Integer nextX = this.x;
		// Integer nextY = this.y - 1;
		// Cell nextCell;
		// while (nextY >= 1) {
		// nextCell = mixture.get(nextX, nextY);
		// if (nextCell != null && nextCell.value != 0) {
		// if (this.value == 0) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// this.down(mixture);
		// } else if (nextCell.value == this.value) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// }
		// break;
		// } else {
		// nextY--;
		// }
		// }
	}

	void left(Mixture mixture) {
		move(mixture, Mixture.left);
		// Integer nextX = this.x + 1;
		// Integer nextY = this.y;
		// Cell nextCell;
		// while (nextX <= mixture.x) {
		// nextCell = mixture.get(nextX, nextY);
		// if (nextCell != null && nextCell.value != 0) {
		// if (this.value == 0) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// this.left(mixture);
		// } else if (nextCell.value == this.value) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// }
		// break;
		// } else {
		// nextX++;
		// }
		// }
	}

	void right(Mixture mixture) {
		move(mixture, Mixture.right);
		// Integer nextX = this.x - 1;
		// Integer nextY = this.y;
		// Cell nextCell;
		// while (nextX >= 1) {
		// nextCell = mixture.get(nextX, nextY);
		// if (nextCell != null && nextCell.value != 0) {
		// if (this.value == 0) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// this.right(mixture);
		// } else if (nextCell.value == this.value) {
		// this.value += nextCell.value;
		// nextCell.value = 0;
		// }
		// break;
		// } else {
		// nextX--;
		// }
		// }
	}

	@Override
	public String toString() {
		String str;
		str = value + "";
		return str;
	}

	public String toDebugString() {
		String str;
		str = "[" + x + "," + y + "]:v:" + value;
		return str;
	}

	// @Override
	// public int hashCode() {
	// final Integer prime = 31;
	// Integer result = 1;
	// result = prime * result + x;
	// result = prime * result + y;
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Cell other = (Cell) obj;
	// if (x != other.x)
	// return false;
	// if (y != other.y)
	// return false;
	// return true;
	// }

}
