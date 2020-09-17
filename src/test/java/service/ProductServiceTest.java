package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Korki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl userService = new ProductServiceImpl(products);
        List<Product> listFromTestClass = userService.getAllProducts();

        Assert.assertEquals(products, listFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Kurtka", 99, 3, "Blue", 1, "M", "Poliester"));
        products.add(new Boots(2l, "Trampki", 49, 5, "White", 2, 37, true));


        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3l, "Koszulka", 15, 1, "Green", 3, "M", "Poliester"));
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetCountProductsPositive() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Korki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetCountProductsNegative() {
        List<Product> products = new ArrayList<Product>();

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        Product boots = new Boots(2l, "Boots", 50, 2, "Red", 2, 43, false);
        products.add(boots);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Boots");

        Assert.assertEquals(boots, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Korki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Bluzka");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWarehousePositive() {

        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Korki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("Bluza");

        Assert.assertTrue(isProductOnWarehouse);
    }

    @Test
    public void testIsProductOnWarehouseNegative() {

        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Bluza", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Korki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("Koszulka");

        Assert.assertFalse(isProductOnWarehouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Boots(2l, "Boots", 50, 2, "Red", 2, 43, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Boots");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Koszulka", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Trampki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean productExist = productService.isProductExist("Majtki");

        Assert.assertFalse(productExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Koszulka", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Trampki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(1l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExisByIdtWhenNoExist() {
        List<Product> products = new ArrayList<Product>();

        products.add(new Cloth(1l, "Koszulka", 35, 4, "Grey", 1, "L", "Cotton"));
        products.add(new Boots(2l, "Trampki", 50, 2, "Red", 2, 43, false));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(5l);

        Assert.assertFalse(isProductExist);
}
    }