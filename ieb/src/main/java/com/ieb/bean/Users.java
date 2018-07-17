package com.ieb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 账户表
 * @author zhengjie
 */
@Entity
@Table(name="users")
public class Users extends DateField implements Serializable {
	private static final long serialVersionUID = 3164785027935296580L;
	private Integer id;				//数据表主键唯一标识
	private String loginname;		//用户登录名
	private String password;		//用户登录密码
	private Integer status;			//用户账户状态
	private String email;			//用户EMAIL(密码丢失时可以通过email找回)
	private String phone;			//用户手机号(必填)
	private String name;			//用户真实姓名(公司组织的使用名)
	private String qq;				//用户使用qq(可选)
	private Department department;	//用户所在部门
	private List<Role> roles;		//一个用户可以有多个角色
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="loginname",length=100,nullable=false)
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Column(name="password",length=100,nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="status",length=1,nullable=false)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name="email",length=50,nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="phone",length=20,nullable=false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="name",length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="qq",length=19,nullable=true)
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@JoinColumn(name="department",nullable=true)
	@ManyToOne
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@JoinTable(name="user_role",
			joinColumns= {@JoinColumn(name="user_id",referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="role_id",referencedColumnName="ID")})
	@ManyToMany(fetch=FetchType.EAGER)
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", loginname=" + loginname + ", password=" + password + ", status=" + status
				+ ", email=" + email + ", phone=" + phone + ", name=" + name + ", qq=" + qq + ", department="
				+ department + ", roles=" + roles + "]";
	}
}
