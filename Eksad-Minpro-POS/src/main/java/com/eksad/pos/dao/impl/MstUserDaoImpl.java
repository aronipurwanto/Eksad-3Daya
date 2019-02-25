package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.MstUserDao;
import com.eksad.pos.model.MstUserModel;

@Repository
public class MstUserDaoImpl implements MstUserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstUserModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select x from MstUserModel x order by x.code";
		Query query = session.createQuery(hql);
		List<MstUserModel> result = query.getResultList();
		return result;
	}

	@Override
	public MstUserModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstUserModel x where x.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		MstUserModel result = (MstUserModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstUserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(MstUserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(MstUserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<MstUserModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstUserModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

	@Override
	public MstUserModel getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstUserModel x where x.username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);		
		MstUserModel result = (MstUserModel)query.getSingleResult();
		return result;
	}

}
