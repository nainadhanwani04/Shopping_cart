package com.shopping.client;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.service.OrderDetailService;
import com.shopping.service.OrderDetailServiceImp;
import com.shopping.utils.OrderDetailsRead;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailClient {
    public static void main(String[] args) throws SQLException {                                            //Extracting Data Using File
        OrderDetailsRead orderDetailsRead=new OrderDetailsRead();
        try {
            List<OrderDetail> orderDetailList=orderDetailsRead.OrderDetailRead();
            for (OrderDetail orderDetail:orderDetailList){
                OrderDetailServiceImp orderDetailService = new OrderDetailServiceImp();
                orderDetailService.addOrderDetail(orderDetail);
            }
            OrderDetailService orderDetailService = new OrderDetailServiceImp();
            orderDetailService.updateOrderDetail(12,1);
            orderDetailService.deleteOrderDetail(3);
            orderDetailService.fetchOrderDetail(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
