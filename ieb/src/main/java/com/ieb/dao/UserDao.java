package com.ieb.dao;

import org.springframework.data.repository.CrudRepository;
import com.ieb.bean.Users;

/**
 * @Description UsersDao
 * @author zhengjie
 *
 */
public interface UserDao extends BaseRepositoryDao<Users, Integer>, CrudRepository<Users, Integer>{	
}
