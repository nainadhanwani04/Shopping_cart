package com.shopping.service;

import com.shopping.dao.OrderDaoImpl;
import com.shopping.dao.ProductDaoImpl;
import com.shopping.dao.UserDaoImpl;
import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.Product;
import com.shopping.domain.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nainadhanwani on 2/2/17.
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder(Order order) throws Exception{
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.deleteOrder(id);
    }

    @Override
    public void fetchOrder(int id) {
        Order orderDao = readOrder(id);
        if(orderDao!= null ) {
            System.out.println(orderDao.getId());
            System.out.println(orderDao.getOrderDate());
            System.out.println(orderDao.getAmount());
            System.out.println(orderDao.getUserId());
        }

    }

    @Override
    public Order readOrder(int id) {
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        Order order = new Order();
        try {
            order= orderDaoImpl.readOrder(id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return order;
    }

    @Override
    public void orderdetails(int id) throws SQLException {

        File file = new File("/Users/nainadhanwani/projects/ShoppingCart/OrderReceipt.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            OrderDaoImpl orderDaoImp = new OrderDaoImpl();
            int order_id = id;
            String firstName = "";
            String lastName = "";
            int i = 1;
            String productName;
            int quantity;
            double price;
            List <OrderDetail> orderDetailList = orderDaoImp.orderDetails(id);
            //System.out.println(id);
            ProductDaoImpl productDao = new ProductDaoImpl();
            OrderDaoImpl orderDao = new OrderDaoImpl();
            double amount=0;
            Order order = orderDao.readOrder(id);
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.readUser(order.getUserId());
            firstName = user.getFirstName();
            lastName = user.getLastName();
            bufferedWriter.write("Order Id:" + order_id + "\t"+"Order date:"+order.getOrderDate()+"\t"+ "User id:" + order.getUserId() + "\t" + "Client Name:" + firstName + "\t" + lastName);
            bufferedWriter.write("\n");
            bufferedWriter.write("S.No" + "\t" + "Product Name" + "\t" + "Quantity" + "\t" + "Price" + "\t" + "\t"+"Amount");
            bufferedWriter.write("\n");
            for (OrderDetail orderDetail : orderDetailList) {
                amount+=orderDetail.getAmount();
                Product product = productDao.readProduct(orderDetail.getProductId());
                bufferedWriter.write(i++ + "\t" +product.getName() + "\t"+ "\t"+orderDetail.getQuantity()+"\t"+"\t"+ orderDetail.getPrice()+"\t"+"\t"+orderDetail.getAmount());
                bufferedWriter.write("\n");
            }
            bufferedWriter.write("Total"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+amount);
            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
