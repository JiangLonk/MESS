package numbertrans;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {

		String fileSize = "4406868";
		String[] unit = new String[] { "B", "KB", "MB", "GB", "TB" };
		int i = 0;
		/* 四位数单位 */
		double size = Double.parseDouble(fileSize);
		 while (size >= 1000 && i < 4) {
			size = Double.parseDouble(fileSize);
			size = size / 1024;
			fileSize = String.format("%.2f", size);
			i++;
		}
		System.out.println(fileSize + unit[i]);

		// String stri = "1";
		// for (int i = 0; i < 100; i++) {
		// System.out.println(fmt(stri, 1));
		// stri += "1";
		// }
	}

	static String unit(int t) {
		if (t <= 1) {
			return "";
		}
		String result = "";
		for (int i = 1; i < t; i++) {
			result += "万";
		}
		return new StringBuffer(result.replace("万万", "亿")).reverse().toString();
	}

	static String fmt(String i, int t) {
		i = i.replace(",", "");
		i = i.replace(" ", "");
		BigDecimal n = new BigDecimal(i);
		BigDecimal tthousand = new BigDecimal("10000");
		if (n.compareTo(tthousand) == 1) {
			t++;
			return fmt(n.divide(tthousand).toString(), t);
		} else {
			String nstr = n.toString();
			if (t > 1) {
				String[] nsplit = nstr.split("[.]");
				String result = nsplit[0] + unit(t);
				result += nsplit[1].substring(0, 1) + "千" + unit(t - 1);
				return result;
			} else {
				return nstr + unit(t);
			}
		}
	}
}
