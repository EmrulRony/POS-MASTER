package com.solutioniabd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	@Column(name="buying_price")
	private int buyingPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	private Date expiryDate;

	@Column(name="made_by_country")
	private String madeByCountry;

	@Column(name="product_color1")
	private String productColor1;

	@Column(name="product_color2")
	private String productColor2;

	@Column(name="product_color3")
	private String productColor3;

	@Column(name="product_color4")
	private String productColor4;

	@Column(name="product_color5")
	private String productColor5;

	@Column(name="product_color6")
	private String productColor6;

	@Column(name="product_name")
	private String productName;

	@Column(name="selling_price")
	private int sellingPrice;

	//bi-directional many-to-one association to Catagory
	@ManyToOne
	@JoinColumn(name="catagory_id")
	private Catagory catagory;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBuyingPrice() {
		return this.buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMadeByCountry() {
		return this.madeByCountry;
	}

	public void setMadeByCountry(String madeByCountry) {
		this.madeByCountry = madeByCountry;
	}

	public String getProductColor1() {
		return this.productColor1;
	}

	public void setProductColor1(String productColor1) {
		this.productColor1 = productColor1;
	}

	public String getProductColor2() {
		return this.productColor2;
	}

	public void setProductColor2(String productColor2) {
		this.productColor2 = productColor2;
	}

	public String getProductColor3() {
		return this.productColor3;
	}

	public void setProductColor3(String productColor3) {
		this.productColor3 = productColor3;
	}

	public String getProductColor4() {
		return this.productColor4;
	}

	public void setProductColor4(String productColor4) {
		this.productColor4 = productColor4;
	}

	public String getProductColor5() {
		return this.productColor5;
	}

	public void setProductColor5(String productColor5) {
		this.productColor5 = productColor5;
	}

	public String getProductColor6() {
		return this.productColor6;
	}

	public void setProductColor6(String productColor6) {
		this.productColor6 = productColor6;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSellingPrice() {
		return this.sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Catagory getCatagory() {
		return this.catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

}