package cn.muke.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.muke.ssh.domain.Product;
import cn.muke.ssh.service.ProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private ProductService productService;
	private Product product=new Product();
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	public String save(){
		System.out.println("Action---save------");
		productService.save(product);
		return NONE;
	}
	
	
}
