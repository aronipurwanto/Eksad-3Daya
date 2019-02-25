package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.MstItemDao;
import com.eksad.pos.model.MstItemModel;

@Repository
public class MstItemDaoImpl implements MstItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstItemModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select x from MstItemModel x order by x.code";
		Query query = session.createQuery(hql);
		List<MstItemModel> result = query.getResultList();
		return result;
	}

	@Override
	public MstItemModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstItemModel x where x.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		MstItemModel result = (MstItemModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(MstItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(MstItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<MstItemModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstItemModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}
