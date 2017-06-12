package mine;

public class CellBean implements CellContent {
	private int x;
	private int y;
	private boolean fazzy = true;
	private boolean flag = false;
	private int content = 空;

	public CellBean() {

	}

	public CellBean(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int dig() {
		return this.content;
	}

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
