package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.MstCategoryModel;

public interface MstCategoryDao {
	public List<MstCategoryModel> getList();
	public List<MstCategoryModel> search(String key);
	public MstCategoryModel getById(Integer id);
	public Boolean checkName(String name);
	public void insert(MstCategoryModel model);
	public void update(MstCategoryModel model);
	public void delete(MstCategoryModel model);
}
