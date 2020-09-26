package entity;


public class Boots extends Product {
    int size;
    boolean isNaturalSkin;
    public final static char PRODUCT_TYPE = 'B';


    public Boots(Long id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }
    public int getSize(){
        return size;
    }
    public boolean isNaturalSkin(){
        return  isNaturalSkin;
    }
    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
    }
}