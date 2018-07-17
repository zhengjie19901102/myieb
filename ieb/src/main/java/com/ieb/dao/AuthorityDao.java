package com.ieb.dao;

import org.springframework.data.repository.CrudRepository;

import com.ieb.bean.Authority;

public interface AuthorityDao extends BaseRepositoryDao<Authority, Integer>, CrudRepository<Authority, Integer>{
}
