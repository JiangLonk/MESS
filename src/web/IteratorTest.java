package web;

public class IteratorTest {
	public static void main(String[] args) {
		CldCalc cldCalc = new CldCalc();
		double time;
		double sum = 0;
		for (int j = 1; j < 11; j++) {
			for (Integer i = 0; i < 100000000l; i++) {

			}
			time = cldCalc.stopCalc();
			sum += time;
			System.out.println("第" + j + "次热身：" + time);
		}
		System.out.println("------> 平均：" + sum / 10);
		System.out.println();
		sum = 0;

		for (int j = 1; j < 11; j++) {
			for (Integer i = 0; i < 1000000000l; i++) {

			}
			time = cldCalc.stopCalc();
			sum += time;
			System.out.println("第" + j + "次十亿次i++：" + time);
		}
		System.out.println("------> 平均：" + sum / 10);
		System.out.println();
		sum = 0;

		for (int j = 1; j < 11; j++) {
			for (Integer i = 0; i < 1000000000l; ++i) {

			}
			time = cldCalc.stopCalc();
			sum += time;
			System.out.println("第" + j + "次十亿次++i：" + time);
		}
		System.out.println("------> 平均：" + sum / 10);
		System.out.println();
		sum = 0;
	}
}
