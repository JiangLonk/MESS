package excel;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	public static <T extends ExcelConvert<?>> Workbook convertExcel(List<String[]> dataList) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			/* 数据查询 */
			if (workbook != null && dataList != null) {
				/* 模板文件的 sheet */
				HSSFSheet sheet = workbook.createSheet();
				for (int i = 0; i < dataList.size(); i++) {
					Row row = sheet.createRow(i);
					String[] dataArray = dataList.get(i);
					for (int j = 0; j < dataArray.length; j++) {
						row.createCell(j).setCellValue(dataArray[j]);
					}
				}
			}
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static <T extends ExcelParser> Workbook parseExcel(List<T> dataList) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			/* 数据查询 */
			if (workbook != null && dataList != null) {
				/* 模板文件的 sheet */
				HSSFSheet sheet = workbook.createSheet();
				for (int i = 0; i < dataList.size(); i++) {
					Row row = sheet.createRow(i);
					String[] dataArray = dataList.get(i).parserData();
					for (int j = 0; j < dataArray.length; j++) {
						row.createCell(j).setCellValue(dataArray[j]);
					}
				}
			}
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
