package com.shopping.service;

import com.shopping.dao.ProductDaoImpl;
import com.shopping.domain.Product;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(Product product) {
        ProductDaoImpl productDao= new ProductDaoImpl();
        productDao.addProducts(product);
    }

    @Override
    public Product readProduct(int id) throws SQLException {
     Product product = new Product();
     ProductDaoImpl productDao1 = new ProductDaoImpl();
     product=productDao1.readProduct(id);
     return product;
    }

    @Override
    public void updateProduct(Product product, int id) throws SQLException {
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.updateProduct(product,id);

    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.deleteProduct(id);

    }

    @Override
    public void fetchProduct(int id) {
        try {
            Product productDaoImp = readProduct(id);
            if(productDaoImp!= null ) {

                System.out.println(productDaoImp.getId());
                System.out.println(productDaoImp.getName());
                System.out.println(productDaoImp.getCode());
                System.out.println(productDaoImp.getPrice());
                System.out.println(productDaoImp.getStock());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
