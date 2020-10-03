package entity;


import entity.enums.Color;
import entity.enums.SkinType;

public class Boots extends Product {
    int size;
    private SkinType skinType;
    public final static char PRODUCT_TYPE = 'B';


    public Boots(Long id, String productName, float price, float weight, Color color, int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }
    public int getSize(){
        return size;
    }
    public SkinType skinType(){
        return  skinType;
    }
    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + skinType;
    }
}