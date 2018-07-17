package com.ieb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Department;
import com.ieb.bean.Users;
import com.ieb.dao.DepartmentDao;
import com.ieb.expect.OptionalFaildException;
import com.ieb.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao deptDao;
	
	@Override
	public void addDept(Department dept) throws OptionalFaildException {
		deptDao.save(dept);
	}

	@Override
	public void deleteDept(Department dept) throws OptionalFaildException {
		deptDao.deleteEntity(dept.getId());
	}

	@Override
	public void updateDept(Department dept) throws OptionalFaildException {
		OptionalFaildException optionalFaildException = new OptionalFaildException("部门修改失败");
		try {
			Department deptData = deptDao.findOne(dept.getId());
			if(null != deptData) {
				deptDao.saveAndFlush(dept);
			}else {
				throw optionalFaildException;
			}
		}catch(OptionalFaildException e) {
			throw e;
		}
	}

	@Override
	public Page<Department> findDeptForPage(CustomPage page) throws OptionalFaildException {
		Pageable pageable = new PageRequest(page.getCurrentPage(), page.getPageNum());
		Page<Department> deptPage = deptDao.findAll(pageable);
		return deptPage;
	}

	@Override
	public Page<Department> findDeptForPageByExample(CustomPage page) throws OptionalFaildException {
		Page<Department> findDeptForPageByExample = deptDao.findForPageByExample(page);
		return findDeptForPageByExample;
	}

}
