package com.muke.employee.dao;

import java.util.List;



public interface BaseDao {
	//###########################
	//######id############

	public Object findById(Class<?> clazz,java.io.Serializable id); 
	//############hql
	public List<?> excuteQuery(String hql);
	//############
	public List<?> excuteQueryByPage(String hql,int pageNow,int PageSize);
	//##################
	public void add(Object obj);
	//public boolean exists(User user);
	//###############
	public List<?> executeUpdate(String hql);
	
	//###########################
	public Object uniqueQuery(String hql);
	//######hql#########getPageCount
	public int getPageCount(String hql,int pageSize);
	//######hql#########getTotalCount
	public int getTotalCount(String hql,int pageSize);
	//8.######id###############
	public void delById(Class<?> clazz,java.io.Serializable id);
	//9.######Object######
	public void update(Object object);
	

}
