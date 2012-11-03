package sy.pageModel.util;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-2 下午2:53:13
 */

public class Base {
	private int page=1;// 当前页
	private int rows=10;// 每页显示记录数
	private String sort;// 排序字段名
	private String order;
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}
