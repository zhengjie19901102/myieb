package com.ieb.service;

import org.springframework.data.domain.Page;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Role;
import com.ieb.expect.OptionalFaildException;

public interface RoleService {
	// 增加角色
	void addUser(Role role) throws OptionalFaildException;

	// 删除角色
	void deleteUser(Role role) throws OptionalFaildException;

	// 角色信息更改
	void updateUser(Role role) throws OptionalFaildException;

	// 分页查询角色
	Page<Role> findUserForPage(CustomPage page) throws OptionalFaildException;

	// 带条件分页查询角色
	Page<Role> findUserForPageByExample(CustomPage page) throws OptionalFaildException;
}
