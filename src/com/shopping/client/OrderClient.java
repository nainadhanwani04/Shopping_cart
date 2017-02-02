package com.shopping.client;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class OrderClient {
    public static void main(String[] args) {
        Order order=new Order();
        order.setId(1);
        order.setOrderDate(2017/01/15);
        order.setUserId(1);
        //add to DB

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setId(1);
        //
        //
        //
        orderDetail1.setOrderId(order.getId());
        //order details add to DB

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setId(2);
        //
        //
        //
        orderDetail2.setOrderId(order.getId());
        //order details add to DB

    }
}
