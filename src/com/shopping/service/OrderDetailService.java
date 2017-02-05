package com.shopping.service;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.User;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public interface OrderDetailService {
    public void addOrderDetail(OrderDetail order)throws SQLException;

    public void deleteOrderDetail(int id) throws SQLException;

    public void fetchOrderDetail(int id)throws Exception;

    public void updateOrderDetail(int quantity, int id)throws Exception;

    public OrderDetail readOrderDetail(int id)throws Exception;
}
