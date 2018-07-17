package com.ieb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 部门表
 * @author zhengjie
 */
@Entity
@Table(name="department")
public class Department extends DateField implements Serializable  {
	private static final long serialVersionUID = 1L;
	private Integer id;				//部门主键唯一标识
	private String deptName;		//部门的名称
	//private List<Users> users;		//一个部门中有多个用户
	private Integer status;			//部门标志状态(删除、启用)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="deptname",nullable=false)
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/*@OneToMany(fetch=FetchType.EAGER,mappedBy="department")
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}*/
	
	@Column(name="status",length=1,nullable=false)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	/*@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", users=" + users + ", status=" + status + "]";
	}*/
}
