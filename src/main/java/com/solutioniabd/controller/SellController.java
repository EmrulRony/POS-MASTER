package com.solutioniabd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.solutioniabd.beans.ProductServiceLocal;
import com.solutioniabd.entity.Product;


@Named
@ViewScoped
public class SellController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ProductServiceLocal productService;
	
	private List<Product> productList;
	
	private String productText;
	
	private Product selectedProduct;
	
	private List<Product> cartProduct = new ArrayList<>();
	
	private int totalAmount;
	
	
	// Life-cycle methods
	@PostConstruct
	void init() {
		productList=productService.listProducts();
		
		System.out.println("SellController Called!!!!!!");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("-------------PreDestroy Called---------");
	
	}
	
	// Buttons and event handlers
	public List<Product> completeProdName(String query){
		List <Product> prodList = new LinkedList<>();

		for (Product product:productList) {
			if (product.getProductName().toLowerCase().startsWith(query.toLowerCase())){
				prodList.add(product);
				
			}
		}
		
		return prodList;
	}
	
	public void addToCart() {
		cartProduct.add(selectedProduct);
		
		for (Product product:cartProduct) {
			System.out.println("ProductName: "+ product.getProductName()+", ProductPrice: "+product.getBuyingPrice());
		}
		
		totalAmount=totalCost();
		
	}
	// Helper methods
	
	public int totalCost() {
		int sum=0;
		for (Product prod : cartProduct) {
			sum+=prod.getSellingPrice();
		}
		System.out.println("The sum is "+sum);
		return sum;
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

	public List<Product> getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(List<Product> cartProduct) {
		this.cartProduct = cartProduct;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
