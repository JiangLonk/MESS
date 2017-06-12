package java8.minesweeper;

public class Cell {
	/* 0 -> n */
	private int x;
	/* 0 -> y */
	private int y;

	private boolean fazzy = true;

	private boolean flag = false;

	/* 0 -> 9 */
	private int content = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFazzy() {
		return fazzy;
	}

	public void setFazzy(boolean fazzy) {
		this.fazzy = fazzy;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}
}
