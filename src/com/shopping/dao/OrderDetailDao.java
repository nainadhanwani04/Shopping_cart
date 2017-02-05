package com.shopping.dao;

import com.shopping.domain.OrderDetail;
import com.shopping.domain.Product;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public interface OrderDetailDao {

    public void addOrderDetails(OrderDetail orderDetail);

    public OrderDetail readOrderDetail(int id) throws SQLException;

    public void updateOrderDetail(int quantity,int id) throws SQLException;

    public void deleteOrderDetail(int id) throws SQLException;


}
