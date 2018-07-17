package com.ieb.dao;

import org.springframework.data.repository.CrudRepository;

import com.ieb.bean.Department;

public interface DepartmentDao extends BaseRepositoryDao<Department, Integer>, CrudRepository<Department, Integer> {
}
