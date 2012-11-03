package sy.model;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SyUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "syuser", catalog = "sshe")
public class SyUser implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String password;
	private Date createdatetime;
	private Date modifydatetime;
	private Set<SyuserSyrole> syuserSyroles = new HashSet<SyuserSyrole>(0);

	// Constructors

	/** default constructor */
	public SyUser() {
	}

	/** minimal constructor */
	public SyUser(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public SyUser(String id, String name, String password, Date createdatetime, Date modifydatetime, Set<SyuserSyrole> syuserSyroles) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
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

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PASSWORD", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CREATEDATETIME", length = 19)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "MODIFYDATETIME", length = 19)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syUser")
	public Set<SyuserSyrole> getSyuserSyroles() {
		return this.syuserSyroles;
	}

	public void setSyuserSyroles(Set<SyuserSyrole> syuserSyroles) {
		this.syuserSyroles = syuserSyroles;
	}

}