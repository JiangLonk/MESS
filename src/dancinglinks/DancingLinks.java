package dancinglinks;

import java.util.ArrayList;
import java.util.List;

public class DancingLinks {
	
	/**
	 * 
	 */
	static ArrayList<Integer> columnSet;
	
	/**
	 * 可用行
	 */
	static ArrayList<Integer> rowSet;
	
	public static void main(String[] args) {
		for (List<Integer> list : getList()) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	/**
	 * | 0 0 1 0 1 1 0 | <br>
	 * | 1 0 0 1 0 0 1 | <br>
	 * | 0 1 1 0 0 1 0 | <br>
	 * | 1 0 0 1 0 0 0 | <br>
	 * | 0 1 0 0 0 0 1 | <br>
	 * | 0 0 0 1 1 0 1 | <br>
	 */
	public static List<List<Integer>> getList() {
		Integer[][] mixtureArr = new Integer[][] { { 0, 0, 1, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 0, 1, 0 },
			{ 1, 0, 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1, 0, 1 }, };
		List<List<Integer>> mixtureLst = new ArrayList<List<Integer>>();
		for (Integer[] integers : mixtureArr) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (Integer integer : integers) {
				row.add(integer);
			}
			mixtureLst.add(row);
		}
		return mixtureLst;
	}
}