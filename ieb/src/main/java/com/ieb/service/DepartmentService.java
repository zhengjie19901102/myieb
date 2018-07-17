package com.ieb.service;

import org.springframework.data.domain.Page;

import com.ieb.bean.CustomPage;
import com.ieb.bean.Department;
import com.ieb.expect.OptionalFaildException;

public interface DepartmentService {

	// 增加部门信息
	void addDept(Department dept) throws OptionalFaildException;

	// 删除部门信息
	void deleteDept(Department dept) throws OptionalFaildException;

	// 部门信息更改
	void updateDept(Department dept) throws OptionalFaildException;

	// 分页查询部门列表
	Page<Department> findDeptForPage(CustomPage page) throws OptionalFaildException;

	// 带条件分页查询部门列表
	Page<Department> findDeptForPageByExample(CustomPage page) throws OptionalFaildException;
}
