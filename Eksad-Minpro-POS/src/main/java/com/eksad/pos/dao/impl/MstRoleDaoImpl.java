package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.MstRoleDao;
import com.eksad.pos.model.MstRoleModel;

@Repository
public class MstRoleDaoImpl implements MstRoleDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstRoleModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select x from MstRoleModel x order by x.code";
		Query query = session.createQuery(hql);
		List<MstRoleModel> result = query.getResultList();
		return result;
	}

	@Override
	public MstRoleModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstRoleModel x where x.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		MstRoleModel result = (MstRoleModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstRoleModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(MstRoleModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(MstRoleModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<MstRoleModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from MstRoleModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}
