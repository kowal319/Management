package Validator;

import api.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import javax.xml.validation.Validator;
import java.io.IOException;

public class ProductValidator {
    private static ProductValidator instance = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();

    private ProductValidator () throws IOException{
    }

    public static ProductValidator getInstance() throws IOException{
        if(instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }
    public boolean isValidate(Product product)throws ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException, ProductWeightNoPositiveException{
        if (isProductCountNegative(product.getProductCount()))
            throw new ProductCountNegativeException("Negatywna liczba produktów nie jest akceptowana");
        if (isProductNameEmpty(product.getProductName()))
            throw new ProductNameEmptyException("Pusta nazwa produktu nie jest akceptowana");
        if (isPriceNegative(product.getPrice()))
            throw new ProductPriceNoPositiveException("Cena ponizej 0zl nie jest akceptowana");
        if(isWeightNegative(product.getWeight()))
            throw new ProductWeightNoPositiveException("Waga ponizej 0 nie jest akceptowana");
        return true;
    }

    private boolean isProductCountNegative(int productCount){ return (productCount > 0);}
    private boolean isProductNameEmpty(String productName){ return (productName.length() > 0 );}
    private boolean isPriceNegative(float price){ return (price > 0.0f );}
    private boolean isWeightNegative(float weight){ return (weight > 0.0f);}
}
