package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
@Transactional
public class DepartmentDaoImpl implements DepartmentDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Department.class);
		criteria.setFirstResult(begin);
		criteria.setMaxResults(pageSize);
		List <Department>list=criteria.list();
		return list;
	}

	@Override
	public int findCount() {
		String hql="select count(*) from Department";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Long> list=query.list();
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(department);
	}

	@Override
	public Department findById(Integer did) {
		
		return (Department) sessionFactory.getCurrentSession().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(department);
	}

	@Override
	public List<Department> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

}
