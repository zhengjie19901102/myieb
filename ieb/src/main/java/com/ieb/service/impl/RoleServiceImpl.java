package com.ieb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Role;
import com.ieb.bean.Users;
import com.ieb.dao.RoleDao;
import com.ieb.expect.OptionalFaildException;
import com.ieb.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void addUser(Role role) throws OptionalFaildException {
		try {
			roleDao.save(role);
		} catch (Exception e) {
			OptionalFaildException userOptionalFaildException = new OptionalFaildException("角色保存失败");
			throw userOptionalFaildException;
		}
	}

	@Override
	public void deleteUser(Role role) throws OptionalFaildException {
		roleDao.delete(role);
	}

	@Override
	public void updateUser(Role role) throws OptionalFaildException {
		OptionalFaildException optionalFaildException = new OptionalFaildException("角色修改失败");
		try {
			role = roleDao.findOne(role.getId());
			if (role != null) {
				roleDao.saveAndFlush(role);
			} else {
				throw optionalFaildException;
			}
		} catch (Exception e) {
			throw optionalFaildException;
		}
	}

	@Override
	public Page<Role> findUserForPage(CustomPage page) throws OptionalFaildException {
		// 分页查询需要的信息
		Pageable pageable = new PageRequest(page.getCurrentPage(), page.getPageNum());
		Page<Role> findPage = roleDao.findAll(pageable);
		return findPage;
	}

	@Override
	public Page<Role> findUserForPageByExample(CustomPage page) throws OptionalFaildException {
		Page<Role> findUserForPageByExample = roleDao.findForPageByExample(page);
		return findUserForPageByExample;
	}

}
