package com.shopping.dao;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.domain.Product;
import com.shopping.domain.User;
import com.shopping.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nainadhanwani on 2/2/17.
 */
public class OrderDaoImpl implements OrderDao  {
    @Override
    public void addOrder(Order order) throws Exception {

        java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTime());
        try {
            Connection con = DBConnection.getConnection();
            String query = " insert into orders (id,order_date,amount,user_id)"
                    + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, order.getId());
            preparedStmt.setDate(2, sqlDate);
            preparedStmt.setDouble(3, order.getAmount());
            preparedStmt.setInt(4, order.getUserId());

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        } catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Order readOrder(int id) throws SQLException {
        Order order6 =new Order();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM orders WHERE ID = ?";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {

                int orderId = id;
                Date orderDate = rs.getDate("order_date");
                double amount = rs.getDouble("amount");
                int userId = rs.getInt("user_id");
                order6.setId(orderId);
                order6.setOrderDate(orderDate);
                order6.setAmount(amount);
                order6.setUserId(userId);

            }
            // execute the preparedstatement
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception1!");
            //System.err.println(e.getMessage());
        } finally {
            preparedStmt.close();
            con.close();

        }

        return order6;
    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = " delete from orders where id= ? ";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {
            preparedStmt.setInt(1,id);

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }
/*
    @Override
    public double totalAmount(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        double amount=0;
        String query = "SELECT sum(amount)  as total FROM order_details WHERE order_id = ? and order_id = ";
        //select order_id, sum(amount) from  `order_details` group by order_id;
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()) {
                 amount = rs.getDouble("total");
              //  System.out.println(amount);
            } // execute the preparedstatement
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception1!");
            //System.err.println(e.getMessage());
        } finally {
            preparedStmt.close();
            con.close();

        }
        return amount;
    }

    @Override
    public void orderDetails1(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT o.id,o.user_id,u.user_name from orders o,users u where o.id= ? and o.user_id = u.id";
       // select o.id,o.user_id,u.user_name from orders o,users u where o.id = 1 and o.user_id = u.`id`

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                System.out.println(orderId);
                System.out.println(userId);
                System.out.println(userName);
            } // execute the preparedstatement
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception1!");
            //System.err.println(e.getMessage());
        } finally {
            preparedStmt.close();
            con.close();

        }

    }*/

    @Override
    public List<OrderDetail> orderDetails(int id) throws SQLException {
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetailList = new ArrayList <>();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * from order_details where order_id = ?";
        // select o.id,o.user_id,u.user_name from orders o,users u where o.id = 1 and o.user_id = u.`id`

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()) {
              //  orderDetail.setOrderId(rs.getInt("id"));
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetail.setAmount(rs.getDouble("amount"));
                orderDetailList.add(orderDetail);
            } // execute the preparedstatement
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception1!");
            //System.err.println(e.getMessage());
        } finally {
            preparedStmt.close();
            con.close();

        }
        return orderDetailList;
    }
}
