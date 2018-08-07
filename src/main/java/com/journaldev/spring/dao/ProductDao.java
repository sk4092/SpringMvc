package com.journaldev.spring.dao;

import java.util.List;
import com.journaldev.spring.model.Product;

public interface ProductDao {


	public void addProduct(Product p);
	public void updateProduct(Product p);
	public List<Product> listProducts();
	public Product getProductById(int id);
	public void removeProduct(int id);
}
