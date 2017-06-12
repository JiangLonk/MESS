package util;

/**
 * @author zhangkc
 *
 */
public class CommonUtils {

	/**
	 * ȡ����Ŀclass·��
	 * 
	 * @return
	 */
	public String getClassPath() {
		String path = "";
		path = this.getClass().getClassLoader().getResource("/").getPath();
		if (path != "") {
			path = path.substring(1);
		}
		System.out.println(path);
		return path;
	}

	public String getWebContentPath() {
		String path = "";
		path = getClassPath();
		path = path.split("/classes")[0];
		System.out.println(path);
		return path;
	}

}
