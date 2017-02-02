package com.shopping.domain;


import java.util.Date;
import java.util.List;

/**
 * Created by nainadhanwani on 1/25/17.
 */
public class Order {
private  int id;
private Date orderDate;
private double amount;
private int userId;
private List<OrderDetail> orderdetail;

    public List<OrderDetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<OrderDetail> orderdetail) {
        this.orderdetail = orderdetail;
    }



    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Date getOrderDate() {

        return orderDate;
    }

    public void setOrderDate() {

        this.orderDate = orderDate;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public void setOrderDate(int i) {
    }
}
