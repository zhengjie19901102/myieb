package com.ieb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Users;
import com.ieb.dao.UserDao;
import com.ieb.expect.OptionalFaildException;
import com.ieb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// Users相关Dao
	@Autowired
	private UserDao userDao;

	// User保存Service实现
	@Override
	public void addUser(Users users) throws OptionalFaildException {
		try {
			userDao.save(users);
		} catch (Exception e) {
			OptionalFaildException userOptionalFaildException = new OptionalFaildException("Users保存失败");
			throw userOptionalFaildException;
		}
	}

	// User删除Service实现: 传入一个Users对象
	@Override
	public void deleteUser(Users users) throws OptionalFaildException {
		try {
			Integer userId = users.getId();
			boolean isExists = userDao.exists(userId);
			if (isExists) {
				userDao.deleteEntity(userId);
			}
		} catch (Exception e) {
			OptionalFaildException userOptionalFaildException = new OptionalFaildException("Users删除失败");
			throw userOptionalFaildException;
		}
	}

	// User更改Service实现:传入一个Users对象
	@Override
	public void updateUser(Users users) throws OptionalFaildException {
		OptionalFaildException optionalFaildException = new OptionalFaildException("Users修改失败");
		try {
			users = userDao.findOne(users.getId());
			if (users != null) {
				userDao.saveAndFlush(users);
			} else {
				throw optionalFaildException;
			}
		} catch (Exception e) {
			throw optionalFaildException;
		}
	}

	// 分页查询用户
	@Override
	public Page<Users> findUserForPage(CustomPage page) throws OptionalFaildException {
		// 分页查询需要的信息
		Pageable pageable = new PageRequest(page.getCurrentPage(), page.getPageNum());
		Page<Users> findAll = userDao.findAll(pageable);
		return findAll;
	}

	// 带条件分页查询用户
	@Override
	public Page<Users> findUserForPageByExample(CustomPage page) throws OptionalFaildException {
		Page<Users> findUserForPageByExample = userDao.findForPageByExample(page);
		return findUserForPageByExample;
	}
}
