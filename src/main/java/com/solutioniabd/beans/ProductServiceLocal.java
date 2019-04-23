package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Local;

import com.solutioniabd.entity.Catagory;
import com.solutioniabd.entity.Product;

@Local
public interface ProductServiceLocal {
	public void addProduct(Product prod, Catagory cat);
	public void updateProduct(Product prod, Catagory cat);
	public void removeProd(Product prod , Catagory cat);
	public List<Product> listProducts();
}
