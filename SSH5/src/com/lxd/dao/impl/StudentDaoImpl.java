package com.lxd.dao.impl;


import java.util.List;


import org.springframework.stereotype.Component;

import com.lxd.bean.Student;

import com.lxd.dao.StudentDao;

@Component
public class StudentDaoImpl  extends BaseDaoImpl implements StudentDao {

	@SuppressWarnings("unchecked")
	public Student existUser(Student student) {
		// TODO Auto-generated method stub
		System.out.println("AdminDao############"+student.getId()+"#######"+"##################"+student.getPassword());
		String hql="from Student where name='"+student.getName()+"' and password='"+student.getPassword()+"'";
		
		System.out.println("#########hql"+hql);

		
		List<Student> list=(List<Student>) this.excuteQuery(hql);
		
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
