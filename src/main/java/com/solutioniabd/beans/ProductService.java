package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.solutioniabd.entity.Catagory;
import com.solutioniabd.entity.Product;

@Stateless

public class ProductService implements ProductServiceLocal {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addProduct(Product prod, Catagory cat) {
		em.persist(cat);
		em.persist(prod);
		em.flush();
		System.out.println("------------Product Saved-------------");
	}

	@Override
	public void updateProduct(Product prod, Catagory cat) {
		em.merge(cat);
		em.merge(prod);
	}

	@Override
	public void removeProd(int prodId) {
		Product product = em.find(Product.class, prodId);
		em.remove(product);
	}

	@Override
	public List<Product> listProducts() {
		
		TypedQuery<Product> query=em.createNamedQuery("Product.join.Catagory.findAll", Product.class);
		return query.getResultList();
	}

}
