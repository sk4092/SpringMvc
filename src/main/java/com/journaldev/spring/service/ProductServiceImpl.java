package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ProductDao;
import com.journaldev.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		return productDao.listProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		productDao.removeProduct(id);
	}

}
