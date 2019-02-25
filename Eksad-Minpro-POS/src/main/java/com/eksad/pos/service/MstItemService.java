package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.MstItemModel;

public interface MstItemService {
	public List<MstItemModel> getList();
	public List<MstItemModel> search(String key);
	public MstItemModel getById(Integer id);
	public void insert(MstItemModel model);
	public void update(MstItemModel model);
	public void delete(MstItemModel model);
}
