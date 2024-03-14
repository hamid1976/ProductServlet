package com.ecommerce.beans;

public class Product {
 
    private int productId;
    private String productName;
    private double price;
    private double wholesalePrice;
    private String productType;
    private String productWeight;
    private String productHeight;
    private int quantity;
    private String description;

  
    public Product(){
    	
    }
    
   public Product(String productName, double price, double wholesalePrice, String productType, String productWeight,
			String productHeight, int quantity, String description) {
		super();
		
		this.productName = productName;
		this.price = price;
		this.wholesalePrice = wholesalePrice;
		this.productType = productType;
		this.productWeight = productWeight;
		this.productHeight = productHeight;
		this.quantity = quantity;
		this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(String productHeight) {
        this.productHeight = productHeight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




