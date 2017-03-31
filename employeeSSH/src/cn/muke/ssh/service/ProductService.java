package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.ProductDao;
import cn.muke.ssh.domain.Product;
@Transactional
public class ProductService {
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("ServiceÖÐµÄsave");
		productDao.save(product);
	}
	
}
