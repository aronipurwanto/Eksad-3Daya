package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.MstItemDao;
import com.eksad.pos.model.MstItemModel;
import com.eksad.pos.service.MstItemService;

@Service
@Transactional
public class MstItemServiceImpl implements MstItemService {
	@Autowired
	private MstItemDao dao;
	
	@Override
	public List<MstItemModel> getList() {
		return this.dao.getList();
	}

	@Override
	public MstItemModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstItemModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(MstItemModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(MstItemModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<MstItemModel> search(String key) {
		return this.dao.search(key);
	}
}
