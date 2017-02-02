package com.shopping.dao;

import com.shopping.domain.Order;
import com.shopping.domain.OrderDetail;
import com.shopping.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by nainadhanwani on 1/30/17.
 */
public class OrderDetailDaoImp implements OrderDetailDao {

    @Override
    public void addOrderDetails(OrderDetail orderDetail) {
        try{
            Connection con = DBConnection.getConnection();
            String query = " insert into order_details (id,order_id,product_id,quantity,price, amount)"
                    + " values (?, ?, ?, ?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setInt(1, orderDetail.getId());
            preparedStmt.setInt(2,orderDetail.getOrderId() );
            preparedStmt.setInt(3, orderDetail.getProductId());
            preparedStmt.setInt(4, orderDetail.getQuantity());
            preparedStmt.setDouble(5, orderDetail.getPrice());
            preparedStmt.setDouble(6,orderDetail.getAmount());

            // execute the preparedstatement
            preparedStmt.execute();

            con.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }
}
