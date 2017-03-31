package cn.muke.ssh.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import cn.muke.ssh.domain.Product;

public class ProductDao{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("DAOÖÐµÄsave");
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
	}

	



}
