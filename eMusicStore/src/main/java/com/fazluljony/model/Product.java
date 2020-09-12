package com.fazluljony.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name= "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int productId;
	
	@NotEmpty(message="Product Name can not be empty.")
	@Column(name="productname")
	private String productName;
	
	@Column(name="productcondition")
	private String productCondition;
	
	@Column(name="productcatagory")
	private String productCatagory;
	
	@Column(name="productdescription")
	private String productdescription;
	
	@Column(name="productmanufacturer")
	private String productmanufacturer;
	
	@Max(value=100000,message="Product price can not be greater than 100000")
	@Min(value=0,message="Product price can not be less than Zero")
	@Column(name="productPrice")
	private double productPrice;
	
	@Min(value=0,message="Product price can not be less than Zero")
	@Column(name="productInStock")  
	private int productInStock;
	
	@Transient
	private MultipartFile productImage;

	public Product() {
		
	}
	
	
	public MultipartFile getProductImage() {
		return productImage;
	}



	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
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

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductmanufacturer() {
		return productmanufacturer;
	}

	public void setProductmanufacturer(String productmanufacturer) {
		this.productmanufacturer = productmanufacturer;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCondition="
				+ productCondition + ", productCatagory=" + productCatagory + ", productdescription="
				+ productdescription + ", productmanufacturer=" + productmanufacturer + ", productPrice=" + productPrice
				+ ", productInStock=" + productInStock + ", productImage=" + productImage + "]";
	}



	

	 
}
