package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product").list();
		for(Product p : productsList){
			System.out.println("Person List::"+p);
		}
		return productsList;
	}

	@Override
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product p = (Product) session.get(Product.class, new Integer(id));
		return p;
	}

	@Override
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
	}

}
