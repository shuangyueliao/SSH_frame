package com.lxd.dao;



import com.lxd.bean.Admin;

public interface AdminDao extends BaseDao{
	//############
	
	public Admin checkAdmin(Admin admin);
	
}
