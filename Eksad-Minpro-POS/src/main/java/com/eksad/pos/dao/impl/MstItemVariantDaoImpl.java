package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.MstItemVariantDao;
import com.eksad.pos.model.MstItemVariantModel;

@Repository
public class MstItemVariantDaoImpl implements MstItemVariantDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstItemVariantModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select x from MstItemVariantModel x order by x.code";
		Query query = session.createQuery(hql);
		List<MstItemVariantModel> result = query.getResultList();
		return result;
	}

	@Override
	public MstItemVariantModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstItemVariantModel x where x.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		MstItemVariantModel result = (MstItemVariantModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstItemVariantModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(MstItemVariantModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(MstItemVariantModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<MstItemVariantModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstItemVariantModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}
