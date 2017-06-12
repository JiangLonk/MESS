package util;

import java.util.Collection;
/**
 * Grid使用
 * @author tongpuxin
 */
public class ExGridLoad {
	/**总记录*/
	private Long totalCount;
	/**总页数*/
	private Long totalPage;
	/**数据集合*/
	private Collection<?> result;

	/**
	 * 获取总记录数
	 */
	public Long getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置总记录数
	 * @param totalCount 总记录数
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取总页数
	 */
	public Long getTotalPage() {
		return totalPage;
	}
	/**
	 * 设置总页数
	 * @param totalPage 总页数
	 */
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 实例化ExGridLoad对象
	 * @param list			数据集合
	 * @param page	分页对象
	 */
	public static ExGridLoad wrapExGridLoad(Collection<?> list, Page page) {
		Long totalCount = page.getTotalCount();
		if(totalCount == null || totalCount <= 0)totalCount = new Long(list.size());
		ExGridLoad exGridLoad = new ExGridLoad();
		exGridLoad.setTotalCount(totalCount);
		exGridLoad.setTotalPage(page.getTotalPage());
		exGridLoad.setResult(list);
		return exGridLoad;
	}
	/**
	 * 实例化ExGridLoad对象
	 * @param list			数据集合
	 */
	public static ExGridLoad wrapExGridLoad(Collection<?> list) {
		ExGridLoad exGridLoad = new ExGridLoad();
		exGridLoad.setResult(list);
		return exGridLoad;
	}
	
	/**
	 * 计算总页数
	 * @param totalCount	总记录数
	 * @param limit			每页显示记录数
	 * @return 总页数
	 */
	public static Long getTotalPage(Long totalCount, Integer limit){
		if(totalCount !=null && limit != null){
			return (totalCount + limit-1) / limit;
		}
		return 1l;
	}
	
	/**
	 * 获取数据集合
	 */
	public Collection<?> getResult() {
		return result;
	}

	/**
	 * 设置数据集合
	 * @param result 数据集合
	 */
	public void setResult(Collection<?> result) {
		this.result = result;
	}
}
