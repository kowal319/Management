package entity;

import entity.enums.Color;

public class Product {

    public final static String PRODUCT_SEPARATOR = "#";
    public final static char PRODUCT_TYPE = 'P';

    Long id;
    String productName;
    float price;
    float weight;
    Color color;
    int productCount;

    public Product(Long id, String productName, float price, float weight, Color color, int productCount){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }
    public Long getId(){
        return id;
    }
    public String getProductName(){
        return productName;
    }
    public float getPrice(){
        return price;
    }
    public float getWeight(){
        return weight;
    }
    public Color getColor(){
        return color;
    }
    public int getProductCount(){
        return productCount;
    }
    protected String getBasicProductString(){
        return id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR + price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }
    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductString();
    }
}