package sy.pageModel.util;

import java.util.List;

/**
 * easyui的datagrid模型
 * 创建人:WangHuifeng
 * 创建时间:2012-11-2 下午2:56:58
 */
@SuppressWarnings("unchecked")
public class DataGrid implements java.io.Serializable {

	private Long total;// 总记录数
	private List rows;// 每行记录
	private List footer;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

}
