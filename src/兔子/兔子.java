package 兔子;

public class 兔子 {
	private int 年龄 = 1;

	public 兔子 生兔子() {
		if (get年龄() >= 3) {
			return new 兔子();
		} else {
			return null;
		}
	}

	public void 成长() {
		年龄++;
	}

	public int get年龄() {
		return 年龄;
	}

	public void set年龄(int 年龄) {
		this.年龄 = 年龄;
	}
}
