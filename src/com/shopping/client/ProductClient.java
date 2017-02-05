package com.shopping.client;

import com.shopping.domain.Product;
import com.shopping.service.ProductServiceImpl;
import com.shopping.utils.ProductRead;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class ProductClient {
    public static void main(String[] args) {
        Product product1 = Product.createProduct("Coffee", "1111", 500, 10);
        ProductServiceImpl productService1 = new ProductServiceImpl();
        productService1.addProduct(product1);
        Product product2 = Product.createProduct("Tea", "2222", 500, 20);
        ProductServiceImpl productService2 = new ProductServiceImpl();
        productService2.addProduct(product2);
        Product product3 = Product.createProduct("Biscuits", "3333", 1500, 30);
        ProductServiceImpl productService3 = new ProductServiceImpl();
        productService3.addProduct(product3);
        Product product4 = Product.createProduct("Fruits", "4444", 2000, 50);
        ProductServiceImpl productService4 = new ProductServiceImpl();
        productService4.addProduct(product4);
        Product product8 = Product.updateProduct(600,30);
        ProductServiceImpl productService6 = new ProductServiceImpl();


        try {
            productService6.updateProduct(product8, 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ProductRead productRead = new ProductRead();                       //Extracting Data Using File
        try {
            List <Product> productList = productRead.ProductRead();

            for (Product product : productList) {
                ProductServiceImpl productService = new ProductServiceImpl();
                productService.addProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProductServiceImpl productService5 = new ProductServiceImpl();
        productService5.fetchProduct(5);
        try {
            productService4.deleteProduct(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
