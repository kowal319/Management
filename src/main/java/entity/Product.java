package entity;

public class Product {
    Long id;
    String productName;
    float price;
    float weight;
    String color;
    int productCount;

    public Product(Long id, String productName, float price, float weight, String color, int productCount){
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
    private float getPrice(){
        return price;
    }
    public float getWeight(){
        return weight;
    }
    public String getColor(){
        return color;
    }
    private int getProductCount(){
        return productCount;
    }
    @Override
    public String toString(){
        return "Product{" +
                "id=" + id +
                ", productName='" + productName +'\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color=" + color + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}