package com.shopping.client;

import com.shopping.domain.Product;
import com.shopping.service.ProductServiceImpl;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class ProductClient {
    public static void main(String[] args) {
        Product product1=Product.createProduct(1,"Coffee","1111",500,10);
        ProductServiceImpl productService1 = new ProductServiceImpl();
        productService1.addProduct(product1);
        Product product2=Product.createProduct(2,"Tea","2222",300,20);
        ProductServiceImpl productService2 = new ProductServiceImpl();
        productService2.addProduct(product2);
        Product product3=Product.createProduct(3,"Biscuits","3333",200,30);
        ProductServiceImpl productService3 = new ProductServiceImpl();
        productService3.addProduct(product3);
        Product product4=Product.createProduct(4,"Fruits","4444",1000,50);
        ProductServiceImpl productService4 = new ProductServiceImpl();
        productService4.addProduct(product4);

        productService1.fetchProduct(1);
        try {
            productService2.deleteProduct(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            productService3.updateProduct(1000,3);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
