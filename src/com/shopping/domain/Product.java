package com.shopping.domain;

/**
 * Created by nainadhanwani on 1/25/17.
 */
public class Product {
    private int id;
    private String name;
    private String code;
    private double price;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {

        return stock;
    }

    public void setStock(int stock) {

        this.stock = stock;
    }

    public static Product createProduct(int id, String name, String code, double price, int stock) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);
        product.setStock(stock);
        return product;
    }
    public static Product updateProduct(double price,int id)
    {
        Product product = new Product();
        product.setId(id);
        product.setPrice(price);
        return product;
    }
}
