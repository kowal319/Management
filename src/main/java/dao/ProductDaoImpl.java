package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;


import java.io.*;
import java.util.List;

import static utils.FileUtils.clearFile;

public class ProductDaoImpl implements ProductDao {

    private final String fileName;
    private final String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException{
        this.fileName = fileName;
        this.productType = productType;
      FileUtils.createNewFile(fileName);
    }

    public void saveProduct(Product product) throws IOException{
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException{
        clearFile(fileName);
        PrintWriter printWriter = new PrintWriter( new FileOutputStream(fileName, true));
        for(Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(Long productId) throws IOException{
        List<Product> products =  getAllProducts();

        for (int i=0; i<products.size(); i++){
            boolean isFoundProduct = products.get(i).getId().equals(productId);
            if (isFoundProduct){
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    public void removeProductByName(String productName) throws IOException{
        List<Product> products = getAllProducts();

        for (int i=0; i< products.size(); i++){
            boolean isFoundProduct = products.get(i).getProductName().equals(productName);
            if(isFoundProduct){
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    public List<Product> getAllProducts() throws IOException{
        List<Product> products = getAllProducts();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null){
            Product product = ProductParser.stringToProduct(readLine, productType);
            if(product != null){
                products.add(product);
            }
        }
        bufferedReader.close();

        return products;
    }

    public Product getProductById(Long productId) throws IOException{
        List<Product> products = getAllProducts();

        for(Product product :products){
            boolean isFoundProduct = product.getId().equals(productId);
            if(isFoundProduct){
                return product;
            }
        }
        return null;
    }

    public Product getProductByProductName (String productName) throws IOException{
        List<Product> products = getAllProducts();

        for (Product product : products){
            boolean isFoundProduct = product.getProductName().equals(productName);
            if(isFoundProduct){
                return product;
            }
        }
        return null;
    }
}
