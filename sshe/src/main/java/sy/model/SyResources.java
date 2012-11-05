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
import javax.persistence.UniqueConstraint;

/**
 * SyResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "syresources", uniqueConstraints = @UniqueConstraint(columnNames = "PID"))
public class SyResources implements java.io.Serializable {

	// Fields

	private String id;
	private SyResources syResources;
	private String text;
	private BigDecimal seq;
	private String src;
	private String descript;
	private String onoff;
	private Set<SyRoleSyresources> syRoleSyresourceses = new HashSet<SyRoleSyresources>(0);
	private Set<SyResources> syResourceses = new HashSet<SyResources>(0);

	// Constructors

	/** default constructor */
	public SyResources() {
	}

	/** minimal constructor */
	public SyResources(String id, BigDecimal seq) {
		this.id = id;
		this.seq = seq;
	}

	/** full constructor */
	public SyResources(String id, SyResources syResources, String text, BigDecimal seq, String src, String descript, String onoff, Set<SyRoleSyresources> syRoleSyresourceses, Set<SyResources> syResourceses) {
		this.id = id;
		this.syResources = syResources;
		this.text = text;
		this.seq = seq;
		this.src = src;
		this.descript = descript;
		this.onoff = onoff;
		this.syRoleSyresourceses = syRoleSyresourceses;
		this.syResourceses = syResourceses;
	}

	// Property accessors
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID", unique = true)
	public SyResources getSyResources() {
		return this.syResources;
	}

	public void setSyResources(SyResources syResources) {
		this.syResources = syResources;
	}

	@Column(name = "TEXT", length = 100)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "SEQ", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSeq() {
		return this.seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}

	@Column(name = "SRC", length = 200)
	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Column(name = "DESCRIPT", length = 100)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Column(name = "ONOFF", length = 1)
	public String getOnoff() {
		return this.onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syResources")
	public Set<SyRoleSyresources> getSyRoleSyresourceses() {
		return this.syRoleSyresourceses;
	}

	public void setSyRoleSyresourceses(Set<SyRoleSyresources> syRoleSyresourceses) {
		this.syRoleSyresourceses = syRoleSyresourceses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syResources")
	public Set<SyResources> getSyResourceses() {
		return this.syResourceses;
	}

	public void setSyResourceses(Set<SyResources> syResourceses) {
		this.syResourceses = syResourceses;
	}

}