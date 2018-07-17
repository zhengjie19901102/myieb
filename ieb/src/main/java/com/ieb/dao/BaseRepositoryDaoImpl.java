package com.ieb.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ieb.bean.CustomPage;
import com.ieb.expect.OptionalFaildException;
@NoRepositoryBean
public class BaseRepositoryDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepositoryDao<T, ID> {
	
	private EntityManager em;
	private Class<T> domainClass;
	
	//构造器DomainClass - EntityManager
	public BaseRepositoryDaoImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
		this.domainClass = domainClass;
	}

	//通过主键修改删除标志位(删除标志位)
	@Override
	public void deleteEntity(ID id) throws OptionalFaildException{
		try {
			//获取表名
			System.err.println("docdsfdsfdsfds------->");
			Class<? extends Object> nameClass = this.domainClass;
			String name = nameClass.getName();
			String jpql = "UPDATE "+name+" e SET e.status=0 WHERE e.id = :id";
			em.createQuery(jpql).setParameter("id", id).executeUpdate();
		}catch(Exception e) {
			throw e;
		}
	}

	// 带条件分页查询
	@Override
	public Page<T> findForPageByExample(CustomPage page) throws OptionalFaildException {
		Map<String, String> searchWord = page.getSearchWord();
		Specification<T> spec = new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				Predicate predicate = null;
				Expression<String> namePath = null;
				if(null != searchWord) {
					for (Map.Entry<String, String> searchWord : searchWord.entrySet()) {
						String key = searchWord.getKey();
						namePath = root.get(key);
						String search = "%"+searchWord.getValue()+"%";
						predicate = cb.like(namePath, search);
						predicates.add(predicate);
					}
				}
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				return null;
			}
		};
		Pageable pageable = new PageRequest(page.getCurrentPage(), page.getPageNum());
		Page<T> findAll = this.findAll(spec, pageable);
		return findAll;
	}
}
