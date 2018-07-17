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
import javax.persistence.Table;

/**
 * 角色列表
 * @author zhengjie
 */
@Entity
@Table(name="role")
public class Role extends DateField implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;			//角色主键唯一标识
	private String roleName;	//角色名称
	private List<Authority> authoritys;			//一个角色对应一堆权限
	private List<Users> users;					//一个角色可以分配给多个用户
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="rolename")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@JoinTable(name="auth_role",
			joinColumns= {@JoinColumn(name="role_id",referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="auth_id",referencedColumnName="ID")})
	@ManyToMany
	public List<Authority> getAuthoritys() {
		return authoritys;
	}
	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="roles")
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
}
