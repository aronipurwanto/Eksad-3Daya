package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.MstUserDao;
import com.eksad.pos.model.MstUserModel;
import com.eksad.pos.service.MstUserService;

@Service
@Transactional
public class MstUserServiceImpl implements MstUserService {
	@Autowired
	private MstUserDao dao;
	
	@Override
	public List<MstUserModel> getList() {
		return this.dao.getList();
	}

	@Override
	public MstUserModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstUserModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(MstUserModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(MstUserModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<MstUserModel> search(String key) {
		return this.dao.search(key);
	}

	@Override
	public MstUserModel getByUsername(String username) {
		return this.dao.getByUsername(username);
	}
}
