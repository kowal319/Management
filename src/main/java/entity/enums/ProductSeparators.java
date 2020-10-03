package entity.enums;

import api.ProductService;

public enum ProductSeparators {
    PROCUT_SEPARATOR("#"), PRODUCT_ID("P"), CLOTH_ID("C"), BOOTS_ID("B");
    private String word;
    ProductSeparators(String word){
        this.word = word;
    }

    public static ProductSeparators getIdByChar(String word) {
        for(ProductSeparators id: ProductSeparators.values()) {
            if (id.getWord().equals(word)) {
                return id;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return word;
    }
    public String getWord(){
        return word;
    }
}

