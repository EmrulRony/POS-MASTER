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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.solutioniabd.beans.ProductServiceLocal;
import com.solutioniabd.entity.Catagory;
import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;
import com.solutioniabd.entity.Product;

@Named
@RequestScoped
public class ProductController {

	@EJB
	ProductServiceLocal productService;

	private Product product = new Product();
	private Catagory catagory = new Catagory();

	List<Product> productList;

	private Map<String, String> colors;

	private List<String> catList;
	
	private String text1;

	// Life cycle methods

	@PostConstruct
	void init() {
		colors = colorMap();
		catList = prodCatList();
		
		productList = productService.listProducts();
		
		System.out.println("Post constract called!!!");

	}

	@PreDestroy
	void dest() {
		System.out.println("Pre destroy called!!!!");
	}

	// Save product information

	public void saveProduct() {
		product.setCatagory(catagory);
		try {
			productService.addProduct(product, catagory);

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}
	}

	// Helper methods
	public Map<String, String> colorMap() {
		colors = new HashMap<String, String>();
		colors.put("Red", "Red");
		colors.put("Green", "Green");
		colors.put("Blue", "Blue");
		colors.put("Yellow", "Yellow");
		return colors;
	}


	public List<String> prodCatList() {
		List<String> cat = new ArrayList<String>();
		cat.add("Mobile");
		cat.add("Headphone");
		cat.add("Charger");
		return cat;
	}
	
	// Button and events
	
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Car Edited");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        Product product = (Product) event.getObject();
	        Catagory catagory =(Catagory) product.getCatagory();
	        productService.updateProduct(product,catagory);
	        productList=productService.listProducts();
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    public void onRowDelete(int productId) {
	    	productService.removeProd(productId);
	    	productList=productService.listProducts();
	    }
	    
	    public List<String> completeText(String query) {
	        List<String> results = new ArrayList<String>();
	        for (Product product:productList) {
	        	if (product.getProductName().toLowerCase().startsWith(query)) {
	        		results.add(product.getProductName());
	        	}
	        }
	         
	        return results;
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

	public List<String> getCatList() {
		return catList;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public void setCatList(List<String> catList) {
		this.catList = catList;
	}

}
