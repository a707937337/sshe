// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * SyRoleSyresources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="syrole_syresources"
    ,catalog="sy"
, uniqueConstraints = {@UniqueConstraint(columnNames="RESOURCES_ID"), @UniqueConstraint(columnNames="ROLE_ID")}
)

public class SyRoleSyresources  implements java.io.Serializable {


    // Fields    

     private String id;
     private SyRole syRole;
     private SyResources syResources;


    // Constructors

    /** default constructor */
    public SyRoleSyresources() {
    }

    
    /** full constructor */
    public SyRoleSyresources(String id, SyRole syRole, SyResources syResources) {
        this.id = id;
        this.syRole = syRole;
        this.syResources = syResources;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ID", nullable=false, length=36)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="ROLE_ID", unique=true, nullable=false)

    public SyRole getSyRole() {
        return this.syRole;
    }
    
    public void setSyRole(SyRole syRole) {
        this.syRole = syRole;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="RESOURCES_ID", unique=true, nullable=false)

    public SyResources getSyResources() {
        return this.syResources;
    }
    
    public void setSyResources(SyResources syResources) {
        this.syResources = syResources;
    }
   








}