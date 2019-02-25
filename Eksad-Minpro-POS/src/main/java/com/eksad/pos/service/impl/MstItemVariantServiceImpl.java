package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.MstItemVariantDao;
import com.eksad.pos.model.MstItemVariantModel;
import com.eksad.pos.service.MstItemVariantService;

@Service
@Transactional
public class MstItemVariantServiceImpl implements MstItemVariantService {
	@Autowired
	private MstItemVariantDao dao;
	
	@Override
	public List<MstItemVariantModel> getList() {
		return this.dao.getList();
	}

	@Override
	public MstItemVariantModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstItemVariantModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(MstItemVariantModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(MstItemVariantModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<MstItemVariantModel> search(String key) {
		return this.dao.search(key);
	}
}
