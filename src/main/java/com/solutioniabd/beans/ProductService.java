package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.solutioniabd.entity.Catagory;
import com.solutioniabd.entity.Product;

@Stateless
public class ProductService implements ProductServiceLocal {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addProduct(Product prod, Catagory cat) {
		em.persist(prod);
		em.persist(cat);
		em.flush();
		
		System.out.println("------------Product Saved-------------");
	}

	@Override
	public void updateProduct(Product prod, Catagory cat) {
		
	}

	@Override
	public void removeProd(Product prod, Catagory cat) {
	}

	@Override
	public List<Product> listProducts() {
		return null;
	}

}
