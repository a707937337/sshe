package sy.model;
// default package

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "symenu", catalog = "sshe")
public class SyMenu implements java.io.Serializable {


	private String id;
	private SyMenu syMenu;
	private String text;
	private String iconcls;
	private String src;
	private BigDecimal seq;
	private Set<SyMenu> syMenus = new HashSet<SyMenu>(0);


	/** default constructor */
	public SyMenu() {
	}

	/** minimal constructor */
	public SyMenu(String id, String text, BigDecimal seq) {
		this.id = id;
		this.text = text;
		this.seq = seq;
	}

	/** full constructor */
	public SyMenu(String id, SyMenu syMenu, String text, String iconcls,
			String src, BigDecimal seq, Set<SyMenu> syMenus) {
		this.id = id;
		this.syMenu = syMenu;
		this.text = text;
		this.iconcls = iconcls;
		this.src = src;
		this.seq = seq;
		this.syMenus = syMenus;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID")
	public SyMenu getSyMenu() {
		return this.syMenu;
	}

	public void setSyMenu(SyMenu syMenu) {
		this.syMenu = syMenu;
	}

	@Column(name = "TEXT", nullable = false, length = 100)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "ICONCLS", length = 50)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "SRC", length = 200)
	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Column(name = "SEQ", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSeq() {
		return this.seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syMenu")
	public Set<SyMenu> getSyMenus() {
		return this.syMenus;
	}

	public void setSyMenus(Set<SyMenu> syMenus) {
		this.syMenus = syMenus;
	}

}