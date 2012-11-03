/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-1 下午4:51:47
 */
package sy.pageModel;

import java.util.Date;

import sy.pageModel.util.Base;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-1 下午4:51:47
 */

public class Goods extends Base{
	private String id;
	private String name;
	private String info;
	private Date createtime;
	private Date modifytime;
	private String bn;
	private Date createtimeEnd;
	private Date createtimeStart;	
	private Date modifytimeEnd;	
	private Date modifytimeStart;
	public Date getCreatetimeEnd() {
		return createtimeEnd;
	}
	public void setCreatetimeEnd(Date createtimeEnd) {
		this.createtimeEnd = createtimeEnd;
	}
	public Date getCreatetimeStart() {
		return createtimeStart;
	}
	public void setCreatetimeStart(Date createtimeStart) {
		this.createtimeStart = createtimeStart;
	}
	public Date getModifytimeEnd() {
		return modifytimeEnd;
	}
	public void setModifytimeEnd(Date modifytimeEnd) {
		this.modifytimeEnd = modifytimeEnd;
	}
	public Date getModifytimeStart() {
		return modifytimeStart;
	}
	public void setModifytimeStart(Date modifytimeStart) {
		this.modifytimeStart = modifytimeStart;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public String getBn() {
		return bn;
	}
	public void setBn(String bn) {
		this.bn = bn;
	}
}
