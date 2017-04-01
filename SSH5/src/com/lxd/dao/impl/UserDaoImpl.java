package com.lxd.dao.impl;



import java.util.List;

import org.springframework.stereotype.Component;


import com.lxd.bean.User;
import com.lxd.dao.UserDao;


@Component
public class UserDaoImpl  extends BaseDaoImpl  implements UserDao{



	@SuppressWarnings("unchecked")
	public User existUser(User user) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("AdminDao############"+user.getId()+"#######"+"##################"+user.getPassword());
		String hql="from User where name='"+user.getName()+"' and password='"+user.getPassword()+"'";
		
		System.out.println("#########hql"+hql);

		
		List<User> list=(List<User>) this.excuteQuery(hql);
		
		System.out.println("list.size#########"+list.size());
//		for(int i=0;i<list.size();i++){
//			System.out.println("AdminDao######DAO###"+"###"+i+
//					"###"+list.get(i));
//		}
		if(list.size()==0)
		{
			return null;
		}else{
			System.out.println("AdminDao######DAO++list.get(0)############"+list.get(0)+"\t"+list.getClass());
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public User existUserBylogin(User user) {
		// TODO Auto-generated method stub
		System.out.println("AdminDao############"+user.getId()+"#######"+"##################"+user.getPassword());
		String hql="from User where name='"+user.getName()+"' and password='"+user.getPassword()+"'";
		
		System.out.println("#########hql"+hql);

		
		List<User> list=(List<User>) this.excuteQuery(hql);
		
		System.out.println("list.size#########"+list.size());
//		for(int i=0;i<list.size();i++){
//			System.out.println("AdminDao######DAO###"+"###"+i+
//					"###"+list.get(i));
//		}
		if(list.size()==0)
		{
			return null;
		}else{
			System.out.println("AdminDao######DAO++list.get(0)############"+list.get(0)+"\t"+list.getClass());
			return list.get(0);
		}
	}

	
	
	
}
