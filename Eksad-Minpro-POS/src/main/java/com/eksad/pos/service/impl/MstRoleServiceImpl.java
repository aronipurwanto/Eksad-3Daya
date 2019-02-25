package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.MstRoleDao;
import com.eksad.pos.model.MstRoleModel;
import com.eksad.pos.service.MstRoleService;

@Service
@Transactional
public class MstRoleServiceImpl implements MstRoleService {
	@Autowired
	private MstRoleDao dao;
	
	@Override
	public List<MstRoleModel> getList() {
		return this.dao.getList();
	}

	@Override
	public MstRoleModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstRoleModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(MstRoleModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(MstRoleModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<MstRoleModel> search(String key) {
		return this.dao.search(key);
	}
}
