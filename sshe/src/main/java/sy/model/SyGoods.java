package sy.model;

// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SyGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sygoods", catalog = "sshe")
public class SyGoods implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String info;
	private Date createtime;
	private Date modifytime;
	private String bn;

	// Constructors

	/** default constructor */
	public SyGoods() {
	}

	/** minimal constructor */
	public SyGoods(String id) {
		this.id = id;
	}

	/** full constructor */
	public SyGoods(String id, String name, String info, Date createtime, Date modifytime, String bn) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.bn = bn;
	}

	// Property accessors
	@Id
	@Column(name = "id", nullable = false, length = 38)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "info")
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "modifytime", length = 19)
	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	@Column(name = "bn")
	public String getBn() {
		return this.bn;
	}

	public void setBn(String bn) {
		this.bn = bn;
	}

}