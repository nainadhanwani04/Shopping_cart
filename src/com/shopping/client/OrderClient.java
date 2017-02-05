package com.shopping.client;

import com.shopping.dao.OrderDaoImpl;
import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.service.OrderDetailServiceImp;
import com.shopping.service.OrderServiceImpl;
import com.shopping.utils.OrderDetailsRead;
import com.shopping.utils.OrderRead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class OrderClient {
    public static void main(String[] args)  {

            Order order3 = Order.createOrder( new Date(), 1000, 1);
            Order order4 = Order.createOrder(new Date(), 500, 2);
            OrderServiceImpl orderService = new OrderServiceImpl();
            OrderServiceImpl orderService1 = new OrderServiceImpl();

        try {
            orderService.addOrder(order3);
            orderService1.addOrder(order4);
            orderService.deleteOrder(2);
            orderService1.deleteOrder(5);
            OrderRead orderRead=new OrderRead();                        //Extracting Data Using File
            List<Order> orderList=orderRead.OrderRead();
            for (Order order:orderList){
                 OrderServiceImpl orderService2 = new OrderServiceImpl();
                 orderService2.addOrder(order);
            }
            OrderDaoImpl orderDao = new OrderDaoImpl();
          //  orderDao.totalAmount(1);
            orderService.fetchOrder(1);
           // orderDao.orderDetails(1);
            OrderServiceImpl orderService2 = new OrderServiceImpl();
            orderService2.orderdetails(1);
           // orderService1.deleteOrder(2);
        }   catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}

