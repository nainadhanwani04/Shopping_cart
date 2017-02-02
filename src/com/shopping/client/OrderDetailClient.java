package com.shopping.client;

import com.shopping.domain.OrderDetail;
import com.shopping.service.OrderDetailServiceImp;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailClient {
    public static void main(String[] args) {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setId(1);
        orderDetail.setOrderId(1);
        orderDetail.setProductId(2222);
        orderDetail.setQuantity(10);
        orderDetail.setPrice(50);
        orderDetail.setAmount(orderDetail.getQuantity()*orderDetail.getPrice());
        orderDetail.setId(2);
        orderDetail.setOrderId(1);
        orderDetail.setProductId(3333);
        orderDetail.setQuantity(20);
        orderDetail.setPrice(100);
        orderDetail.setAmount(orderDetail.getQuantity()*orderDetail.getPrice());
        orderDetail.setId(1);
        orderDetail.setOrderId(1);
        orderDetail.setProductId(4444);
        orderDetail.setQuantity(10);
        orderDetail.setPrice(200);
        orderDetail.setAmount(orderDetail.getQuantity()*orderDetail.getPrice());
        OrderDetailServiceImp orderDetailServiceImp=new OrderDetailServiceImp();
        orderDetailServiceImp.addOrderDetails(orderDetail);
    }

    protected OrderDetail createOrderDetails(int id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        return orderDetail;
    }
}
