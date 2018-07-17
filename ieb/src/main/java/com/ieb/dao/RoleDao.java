package com.ieb.dao;

import org.springframework.data.repository.CrudRepository;

import com.ieb.bean.Role;

public interface RoleDao extends BaseRepositoryDao<Role, Integer>, CrudRepository<Role, Integer> {

}
