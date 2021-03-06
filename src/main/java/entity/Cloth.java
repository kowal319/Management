package entity;

import entity.enums.Color;

public class Cloth extends Product {

    public final static char PRODUCT_TYPE = 'C';
    String size;
    String material;

    public Cloth(Long id, String productName, float price, float weight, Color color, int productCount, String size, String material){
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }
    public String getSize(){
        return size;
    }
    public String getMaterial(){
        return material;
    }
    @Override
    public String toString(){
        return PRODUCT_TYPE + PRODUCT_SEPARATOR  + getBasicProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + material ;

    }
}
