package com.shopping.service;

import com.shopping.dao.OrderDetailDao;
import com.shopping.dao.OrderDetailDaoImp;
import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailServiceImp implements OrderDetailService {
    static OrderDetailDaoImp orderDetailDaoImp = null;

    static {
        orderDetailDaoImp=new OrderDetailDaoImp();
    }

    @Override
    public void addOrderDetails(OrderDetail orderDetail) {

        orderDetailDaoImp.addOrderDetails(orderDetail);
    }

}
