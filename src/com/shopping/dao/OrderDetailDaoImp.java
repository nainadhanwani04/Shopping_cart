package com.shopping.dao;

import com.shopping.domain.OrderDetail;
import com.shopping.domain.Product;
import com.shopping.domain.User;
import com.shopping.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailDaoImp implements OrderDetailDao {

    @Override
    public void addOrderDetails(OrderDetail orderDetail) {
        try {
            Connection con = DBConnection.getConnection();
            String query = " insert into order_details (id,order_id,product_id,quantity,price, amount)"
                    + " values (?, ?, ?, ?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, orderDetail.getId());
            preparedStmt.setInt(2, orderDetail.getOrderId());
            preparedStmt.setInt(3, orderDetail.getProductId());
            preparedStmt.setInt(4, orderDetail.getQuantity());
            preparedStmt.setDouble(5, orderDetail.getPrice());
            preparedStmt.setDouble(6, orderDetail.getAmount());

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    @Override
    public OrderDetail readOrderDetail(int id) throws SQLException {
        OrderDetail orderDetail6 =new OrderDetail();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM order_details WHERE ID = ?";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {

                int orderDetail = id;
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double amount = rs.getDouble("amount");

              /* System.out.println("userid : " + userid);
                System.out.println("username : " + username);*/

                orderDetail6.setId(id);
                orderDetail6.setOrderId(order_id);
                orderDetail6.setProductId(product_id);
                orderDetail6.setQuantity(quantity);
                orderDetail6.setPrice(price);
                orderDetail6.setAmount(amount);

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

        return orderDetail6;
    }

    @Override
    public void updateOrderDetail(int quantity, int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE order_details SET quantity = ? WHERE ID = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        try {
            preparedStmt.setInt(1, quantity);

            preparedStmt.setInt(2, id);

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        }   catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void deleteOrderDetail(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = " delete from order_details where id= ? ";

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
}
