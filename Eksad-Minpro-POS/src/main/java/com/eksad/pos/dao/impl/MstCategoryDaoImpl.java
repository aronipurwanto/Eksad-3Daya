package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.MstCategoryDao;
import com.eksad.pos.model.MstCategoryModel;

@Repository
public class MstCategoryDaoImpl implements MstCategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstCategoryModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select jt from MstCategoryModel jt order by jt.code";
		Query query = session.createQuery(hql);
		List<MstCategoryModel> result = query.getResultList();
		return result;
	}

	@Override
	public MstCategoryModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select jt from MstCategoryModel jt where jt.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		MstCategoryModel result = (MstCategoryModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstCategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(MstCategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(MstCategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<MstCategoryModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstCategoryModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

	@Override
	public Boolean checkName(String name) {
		Boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstCategoryModel x where x.name=:checkName";
		Query query = session.createQuery(hql);
		query.setParameter("checkName", name);
		
		if(query.getSingleResult() != null){
			result = true;
		}
		
		return result;
	}

}
