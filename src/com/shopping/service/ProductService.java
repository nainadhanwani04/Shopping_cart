package com.shopping.service;

import com.shopping.domain.Product;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public interface ProductService {

    public void addProduct(Product product);

    public Product readProduct(int id) throws SQLException;

    public void updateProduct(Product product,int id) throws SQLException;

    public void deleteProduct(int id) throws SQLException;

    public void fetchProduct(int id);
}
