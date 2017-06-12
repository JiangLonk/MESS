package excel;

import java.util.List;

public interface ExcelConvert<K> {
	
	/**
	 * 生成表数据: 第零位为表头
	 * @return
	 */
	public List<String[]> convertData(List<K> data);
	
}
