package com.ieb.service;

import org.springframework.data.domain.Page;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Users;
import com.ieb.expect.OptionalFaildException;

/**
 * @author zhengjie
 * @Description Users相关Service
 */
public interface UserService {

	// 增加登录用户信息
	void addUser(Users users) throws OptionalFaildException;

	// 删除登录用户信息
	void deleteUser(Users users) throws OptionalFaildException;

	// 用户信息更改
	void updateUser(Users user) throws OptionalFaildException;

	// 分页查询用户
	Page<Users> findUserForPage(CustomPage page) throws OptionalFaildException;

	// 带条件分页查询用户
	Page<Users> findUserForPageByExample(CustomPage page) throws OptionalFaildException;

}
