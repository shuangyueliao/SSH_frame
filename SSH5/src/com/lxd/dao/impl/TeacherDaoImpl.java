package com.lxd.dao.impl;

import java.util.List;


import org.springframework.stereotype.Component;

import com.lxd.bean.Teacher;
import com.lxd.dao.TeacherDao;



@Component
public class TeacherDaoImpl  extends BaseDaoImpl implements TeacherDao{

	
//	public void save(User user);
//	public boolean exists(User user);
	@SuppressWarnings("unchecked")
	public Teacher existTeacher(Teacher teacher){
		   
		   System.out.println("teacher############"+teacher.getId()+"#######"+"##################"+teacher.getPassword());
			String hql="from Teacher where name='"+teacher.getName()+"' and password='"+teacher.getPassword()+"'";
			
			System.out.println("#########hql"+hql);

			
			List<Teacher> list=(List<Teacher>) this.excuteQuery(hql);
			
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
