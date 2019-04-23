package com.solutioniabd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.solutioniabd.beans.ProductServiceLocal;
import com.solutioniabd.entity.Catagory;
import com.solutioniabd.entity.Product;

@Named
@RequestScoped
public class ProductController {

	@EJB
	ProductServiceLocal productService;

	private Product product = new Product();
	private Catagory catagory = new Catagory();

	List<Product> productList;
	
	private Map<String,String> colors;
	
	// Life cycle methods

	@PostConstruct
	void init() {
		colors = colorMap();
		
		System.out.println("Post constract called!!!");

	}

	@PreDestroy
	void dest() {
		System.out.println("Pre destroy called!!!!");
	}

	// Save product information

	public void saveProduct() {
		try {
			productService.addProduct(product, catagory);

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}
	}
	
	// Helper methods
	public Map<String,String> colorMap(){
		colors = new HashMap<String,String>();
		colors.put("Red", "Red");
		colors.put("Green", "Green");
		colors.put("Blue", "Blue");
		colors.put("Yellow", "Yellow");
		return colors;
	}

	// Getters and setters
	public ProductServiceLocal getProductService() {
		return productService;
	}

	public void setProductService(ProductServiceLocal productService) {
		this.productService = productService;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Map<String, String> getColors() {
		return colors;
	}

	public void setColors(Map<String, String> colors) {
		this.colors = colors;
	}

}
