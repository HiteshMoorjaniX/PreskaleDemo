package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Preskale")
public class Store {

	
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private int productId;
	private String productName;
	private String productType;
	private int quantity;
	private int availablePkgs;
	private double price;
	private Date manufactoringDate;
	private Date validityPeriod;
	
	public Store(int productId, String productName, String productType, int quantity, int availablePkgs, double price,
			Date manufactoringDate, Date validityPeriod) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.quantity = quantity;
		this.availablePkgs = availablePkgs;
		this.price = price;
		this.manufactoringDate = manufactoringDate;
		this.validityPeriod = validityPeriod;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAvailablePkgs() {
		return availablePkgs;
	}
	public void setAvailablePkgs(int availablePkgs) {
		this.availablePkgs = availablePkgs;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getManufactoringDate() {
		return manufactoringDate;
	}
	public void setManufactoringDate(Date manufactoringDate) {
		this.manufactoringDate = manufactoringDate;
	}
	public Date getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	@Override
	public String toString() {
		return "Store [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", quantity=" + quantity + ", availablePkgs=" + availablePkgs + ", price=" + price
				+ ", manufactoringDate=" + manufactoringDate + ", validityPeriod=" + validityPeriod + "]";
	}
	
	
}
