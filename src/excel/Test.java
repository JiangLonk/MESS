package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public class Test implements ExcelConvert<TestData> {

	public static void main(String[] args) {

		Test test = new Test();
		List<TestData> datas = new ArrayList<>();
		datas.add(new TestData(1l, "1"));
		datas.add(new TestData(2l, "2"));
		datas.add(new TestData(3l, "3"));
		datas.add(new TestData(4l, "4"));
		Workbook workbook = ExcelUtils.convertExcel(test.convertData(datas));
		workbook = ExcelUtils.parseExcel(datas);
		OutputStream out = null;
		try {
			out = new FileOutputStream("D:test3.xls");
			workbook.write(out);
			out.flush();
			workbook = ExcelUtils.parseExcel(datas);
			out = new FileOutputStream("D:test4.xls");
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<String[]> convertData(List<TestData> data) {
		List<String[]> array = new ArrayList<String[]>();
		for (int i = 0; i < data.size(); i++) {
			String[] str = new String[] { data.get(i).getOid().toString(), data.get(i).getName() };
			array.add(str);
		}
		return array;
	}

}
