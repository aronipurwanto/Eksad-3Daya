package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.MstItemVariantModel;

public interface MstItemVariantService {
	public List<MstItemVariantModel> getList();
	public List<MstItemVariantModel> search(String key);
	public MstItemVariantModel getById(Integer id);
	public void insert(MstItemVariantModel model);
	public void update(MstItemVariantModel model);
	public void delete(MstItemVariantModel model);
}
