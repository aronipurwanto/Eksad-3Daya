package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.MstCategoryDao;
import com.eksad.pos.model.MstCategoryModel;
import com.eksad.pos.service.MstCategoryService;

@Service
@Transactional
public class MstCategoryServiceImpl implements MstCategoryService {
	@Autowired
	private MstCategoryDao dao;
	
	@Override
	public List<MstCategoryModel> getList() {
		return this.dao.getList();
	}

	@Override
	public MstCategoryModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstCategoryModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(MstCategoryModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(MstCategoryModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<MstCategoryModel> search(String key) {
		return this.dao.search(key);
	}

	@Override
	public Boolean checkName(String name) {
		return this.dao.checkName(name);
	}
}
