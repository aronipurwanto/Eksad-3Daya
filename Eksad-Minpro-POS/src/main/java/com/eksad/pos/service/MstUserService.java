package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.MstUserModel;

public interface MstUserService {
	public List<MstUserModel> getList();
	public List<MstUserModel> search(String key);
	public MstUserModel getById(Integer id);
	public MstUserModel getByUsername(String username);
	public void insert(MstUserModel model);
	public void update(MstUserModel model);
	public void delete(MstUserModel model);
}
