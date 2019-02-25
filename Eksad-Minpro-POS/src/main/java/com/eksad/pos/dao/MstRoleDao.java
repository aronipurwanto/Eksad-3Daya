package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.MstRoleModel;

public interface MstRoleDao {
	public List<MstRoleModel> getList();
	public List<MstRoleModel> search(String key);
	public MstRoleModel getById(Integer id);
	public void insert(MstRoleModel model);
	public void update(MstRoleModel model);
	public void delete(MstRoleModel model);
}
