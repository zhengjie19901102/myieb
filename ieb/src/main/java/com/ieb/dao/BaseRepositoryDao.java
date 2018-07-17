package com.ieb.dao;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.ieb.bean.CustomPage;
import com.ieb.expect.OptionalFaildException;
@NoRepositoryBean
public interface BaseRepositoryDao<T, ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {

	//通过主键修改删除标志位(删除标志位)
	void deleteEntity(ID id) throws OptionalFaildException;
	
	// 带条件分页查询
	Page<T> findForPageByExample(CustomPage page) throws OptionalFaildException;
	
}
