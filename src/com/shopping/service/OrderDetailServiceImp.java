package com.shopping.service;

import com.shopping.dao.OrderDaoImpl;
import com.shopping.dao.OrderDetailDao;
import com.shopping.dao.OrderDetailDaoImp;
import com.shopping.dao.ProductDaoImpl;
import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.Product;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailServiceImp implements OrderDetailService {
    @Override
    public void addOrderDetail(OrderDetail orderDetail) throws SQLException{
        OrderDetailDaoImp orderDetailDaoImp = new OrderDetailDaoImp();
        orderDetailDaoImp.addOrderDetails(orderDetail);
        ProductDaoImpl productDao = new ProductDaoImpl();

        Product newProduct = productDao.readProduct(orderDetail.getProductId());            //Reducing stock on adding order detail
        int reduceStock;
        if ( (reduceStock = newProduct.getStock()) != 0 ) {
            reduceStock = reduceStock - orderDetail.getQuantity();
            newProduct.setStock(reduceStock);
            //    System.out.println(newProduct.getStock());
            productDao.updateProduct(newProduct, orderDetail.getProductId());
        } else
            System.out.println("Product out of stock");

    }

    @Override
    public void deleteOrderDetail(int id) throws SQLException {
        OrderDetailDaoImp orderDetailDaoImp = new OrderDetailDaoImp();
        orderDetailDaoImp.deleteOrderDetail(id);
    }

    @Override
    public void fetchOrderDetail(int id) throws Exception {
        try {
            OrderDetail orderDetail = readOrderDetail(id);
            if(orderDetail!= null ) {

                System.out.println(orderDetail.getId());
                System.out.println(orderDetail.getOrderId());
                System.out.println(orderDetail.getProductId());
                System.out.println(orderDetail.getQuantity());
                System.out.println(orderDetail.getPrice());
                System.out.println(orderDetail.getAmount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(int quantity, int id) throws Exception {
        OrderDetailDaoImp orderDetailDaoImp = new OrderDetailDaoImp();
        orderDetailDaoImp.updateOrderDetail(quantity, id);
    }

    @Override
    public OrderDetail readOrderDetail(int id) throws Exception {
        OrderDetailDaoImp orderDaoImpl = new OrderDetailDaoImp();
        OrderDetail orderDetail = new OrderDetail();
        try {
            orderDetail= orderDaoImpl.readOrderDetail(id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orderDetail;
    }









  /*  static OrderDetailDaoImp orderDetailDaoImp = null;

    static {
        orderDetailDaoImp=new OrderDetailDaoImp();
    }

    @Override
    public void addOrderDetails(OrderDetail orderDetail) {

        orderDetailDaoImp.addOrderDetails(orderDetail);
    }*/

}
