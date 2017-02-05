package com.shopping.dao;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nainadhanwani on 2/2/17.
 */
public interface OrderDao {

    public void addOrder(Order order) throws Exception;
    public Order readOrder(int id) throws SQLException;
    public void deleteOrder(int id) throws SQLException;
  //  public double totalAmount(int id) throws  SQLException;
//    public void orderDetails1(int id) throws  SQLException;
    public List<OrderDetail> orderDetails(int id) throws SQLException;
}
