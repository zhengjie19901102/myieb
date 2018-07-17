package com.ieb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 账户权限表
 * @author zhengjie
 */
@Entity
@Table(name="authority")
public class Authority extends DateField implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;		//权限主键唯一标识
	private String authName;		//权限名称
	private String visitPath;		//权限可访问路径
	private List<Role> roles;		//权限对应的角色(多对多关系)
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="authname",nullable=false,length=200)
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	@Column(name="visitpath",nullable=false,length=200)
	public String getVisitPath() {
		return visitPath;
	}
	public void setVisitPath(String visitPath) {
		this.visitPath = visitPath;
	}
	
	@ManyToMany(mappedBy="authoritys",fetch=FetchType.LAZY)
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
