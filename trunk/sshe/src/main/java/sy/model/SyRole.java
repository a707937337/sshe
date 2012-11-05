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
 * SyRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "syrole", uniqueConstraints = @UniqueConstraint(columnNames = "PID"))
public class SyRole implements java.io.Serializable {

	// Fields

	private String id;
	private SyRole syRole;
	private String text;
	private BigDecimal seq;
	private String descript;
	private Set<SyRoleSyresources> syRoleSyresourceses = new HashSet<SyRoleSyresources>(0);
	private Set<SyRole> syRoles = new HashSet<SyRole>(0);
	private Set<SyuserSyrole> syuserSyroles = new HashSet<SyuserSyrole>(0);

	// Constructors

	/** default constructor */
	public SyRole() {
	}

	/** minimal constructor */
	public SyRole(String id, BigDecimal seq) {
		this.id = id;
		this.seq = seq;
	}

	/** full constructor */
	public SyRole(String id, SyRole syRole, String text, BigDecimal seq, String descript, Set<SyRoleSyresources> syRoleSyresourceses, Set<SyRole> syRoles, Set<SyuserSyrole> syuserSyroles) {
		this.id = id;
		this.syRole = syRole;
		this.text = text;
		this.seq = seq;
		this.descript = descript;
		this.syRoleSyresourceses = syRoleSyresourceses;
		this.syRoles = syRoles;
		this.syuserSyroles = syuserSyroles;
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
	public SyRole getSyRole() {
		return this.syRole;
	}

	public void setSyRole(SyRole syRole) {
		this.syRole = syRole;
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

	@Column(name = "DESCRIPT", length = 100)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syRole")
	public Set<SyRoleSyresources> getSyRoleSyresourceses() {
		return this.syRoleSyresourceses;
	}

	public void setSyRoleSyresourceses(Set<SyRoleSyresources> syRoleSyresourceses) {
		this.syRoleSyresourceses = syRoleSyresourceses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syRole")
	public Set<SyRole> getSyRoles() {
		return this.syRoles;
	}

	public void setSyRoles(Set<SyRole> syRoles) {
		this.syRoles = syRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syRole")
	public Set<SyuserSyrole> getSyuserSyroles() {
		return this.syuserSyroles;
	}

	public void setSyuserSyroles(Set<SyuserSyrole> syuserSyroles) {
		this.syuserSyroles = syuserSyroles;
	}

}