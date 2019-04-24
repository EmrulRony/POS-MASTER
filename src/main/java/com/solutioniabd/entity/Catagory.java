package com.solutioniabd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catagory database table.
 * 
 */
@Entity
@Table(name="catagory")
@NamedQuery(name="Catagory.findAll", query="SELECT c FROM Catagory c")
public class Catagory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catagory_id")
	private int catagoryId;

	@Column(name="catagory_name")
	private String catagoryName;

//	//bi-directional many-to-one association to Product
//	@OneToMany(mappedBy="catagory")
//	private List<Product> products;

	public Catagory() {
	}

	public int getCatagoryId() {
		return this.catagoryId;
	}

	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatagoryName() {
		return this.catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
//
//	public List<Product> getProducts() {
//		return this.products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
//
//	public Product addProduct(Product product) {
//		getProducts().add(product);
//		product.setCatagory(this);
//
//		return product;
//	}
//
//	public Product removeProduct(Product product) {
//		getProducts().remove(product);
//		product.setCatagory(null);
//
//		return product;
//	}

}