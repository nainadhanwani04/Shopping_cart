package com.shopping.service;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nainadhanwani on 2/2/17.
 */
public interface OrderService {
    public void  addOrder(Order order) throws Exception;

    public void deleteOrder(int id) throws SQLException;

    public void fetchOrder(int id)throws Exception;

    public Order readOrder(int id)throws Exception;

  //  public void totalAmount() throws SQLException;

    public void orderdetails(int id) throws  SQLException;
}
