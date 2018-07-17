package com.ieb.service;

import org.springframework.data.domain.Page;

import com.ieb.bean.Authority;
import com.ieb.bean.CustomPage;
import com.ieb.expect.OptionalFaildException;

public interface AuthorityService {

	// 增加权限信息
	void addAuth(Authority auth) throws OptionalFaildException;

	// 删除权限信息
	void deleteAuth(Authority auth) throws OptionalFaildException;

	// 更改权限信息
	void updateAuth(Authority auth) throws OptionalFaildException;

	// 分页查询权限
	Page<Authority> findUserForPage(CustomPage page) throws OptionalFaildException;

	// 带条件分页查询权限
	Page<Authority> findUserForPageByExample(CustomPage page) throws OptionalFaildException;

}
