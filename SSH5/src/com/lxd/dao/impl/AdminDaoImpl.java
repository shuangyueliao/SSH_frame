package com.lxd.dao.impl;


import java.util.List;


import org.springframework.stereotype.Component;

import com.lxd.bean.Admin;
import com.lxd.dao.AdminDao;

@Component
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao{


	@SuppressWarnings("unchecked")
	public Admin checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		System.out.println("AdminDao############"+admin.getId()+"#######"+"##################"+admin.getPassword());
		String hql="from Admin where name='"+admin.getName()+"' and password='"+admin.getPassword()+"'";
		
		System.out.println("#########hql"+hql);

		
		List<Admin> list=(List<Admin>) this.excuteQuery(hql);
		
		System.out.println("list.size#########"+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("AdminDao######DAO###"+"###"+i+
					"###"+list.get(i));
		}
		if(list.size()==0)
		{
			return null;
		}else{
			System.out.println("AdminDao######DAO++list.get(0)############"+list.get(0)+"\t"+list.getClass());
			return list.get(0);
		}
	}

	
	
	
	

	
}
