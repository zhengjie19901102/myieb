package com.ieb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ieb.bean.Authority;
import com.ieb.bean.CustomPage;
import com.ieb.dao.AuthorityDao;
import com.ieb.expect.OptionalFaildException;
import com.ieb.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authDao;

	@Override
	public void addAuth(Authority auth) throws OptionalFaildException {
		authDao.save(auth);
	}

	@Override
	public void deleteAuth(Authority auth) throws OptionalFaildException {
		authDao.delete(auth);
		
	}

	@Override
	public void updateAuth(Authority auth) throws OptionalFaildException {
		OptionalFaildException optionalFaildException = new OptionalFaildException("权限修改失败");
		try {
			Authority deptData = authDao.findOne(auth.getId());
			if(null != deptData) {
				authDao.saveAndFlush(deptData);
			}else {
				throw optionalFaildException;
			}
		}catch(OptionalFaildException e) {
			throw e;
		}
	}

	@Override
	public Page<Authority> findUserForPage(CustomPage page) throws OptionalFaildException {
		Pageable pageable = new PageRequest(page.getCurrentPage(), page.getPageNum());
		Page<Authority> deptPage = authDao.findAll(pageable);
		return deptPage;
	}

	@Override
	public Page<Authority> findUserForPageByExample(CustomPage page) throws OptionalFaildException {
		Page<Authority> findDeptForPageByExample = authDao.findForPageByExample(page);
		return findDeptForPageByExample;
	}

}
