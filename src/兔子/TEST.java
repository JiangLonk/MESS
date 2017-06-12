package 兔子;

public class TEST {

	public static void main(String[] args) {
		int 月份 = 1;
		兔子厂 兔子厂 = new 兔子厂();
		do {
			System.out.println("当前为第" + 月份 + "月:");
			兔子厂.结算();
			兔子厂.统计();
			月份++;
		} while (true);
	}

}
