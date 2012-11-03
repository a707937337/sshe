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
 * SyuserSyrole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="syuser_syrole"
    ,catalog="sy"
, uniqueConstraints = {@UniqueConstraint(columnNames="SYROLE_ID"), @UniqueConstraint(columnNames="SYUSER_ID")}
)

public class SyuserSyrole  implements java.io.Serializable {


    // Fields    

     private String id;
     private SyRole syRole;
     private SyUser syUser;


    // Constructors

    /** default constructor */
    public SyuserSyrole() {
    }

    
    /** full constructor */
    public SyuserSyrole(String id, SyRole syRole, SyUser syUser) {
        this.id = id;
        this.syRole = syRole;
        this.syUser = syUser;
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
        @JoinColumn(name="SYROLE_ID", unique=true, nullable=false)

    public SyRole getSyRole() {
        return this.syRole;
    }
    
    public void setSyRole(SyRole syRole) {
        this.syRole = syRole;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="SYUSER_ID", unique=true, nullable=false)

    public SyUser getSyUser() {
        return this.syUser;
    }
    
    public void setSyUser(SyUser syUser) {
        this.syUser = syUser;
    }
   








}