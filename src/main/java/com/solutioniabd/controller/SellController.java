package com.solutioniabd.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.solutioniabd.beans.ProductServiceLocal;
import com.solutioniabd.entity.Product;


@Named
@RequestScoped
public class SellController {
	
	@EJB
	ProductServiceLocal productService;
	
	private List<Product> productList;
	
	private String productText;
	
	
	// Life-cycle methods
	@PostConstruct
	void init() {
		productList=productService.listProducts();
		
		System.out.println("SellController Called!!!!!!");
	}
	
	// Buttons and event handlers
	public List<String> completeProdName(String query){
		List <String> prodNameList = new LinkedList<>();
		
		for (Product product:productList) {
			if (product.getProductName().toLowerCase().startsWith(query.toLowerCase())){
				prodNameList.add(product.getProductName());
			}
		}
		
		return null;
	}
	
	
	
	// Getter and setter methods

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getProductText() {
		return productText;
	}

	public void setProductText(String productText) {
		this.productText = productText;
	}
	
	
}
