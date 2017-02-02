package com.shopping.dao;

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
public class ProductDaoImpl implements ProductDao {
    @Override
    public void addProducts(Product product) {
        try{
        Connection con = DBConnection.getConnection();
        String query = " insert into products (id,name,code,price, stock)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setInt(1, product.getId());
        preparedStmt.setString(2,product.getName() );
        preparedStmt.setString(3, product.getCode());
        preparedStmt.setDouble(4, product.getPrice());
        preparedStmt.setInt(5, product.getStock());

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

    @Override
    public Product readProduct(int id) throws SQLException {
        Product product6 =new Product();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM products WHERE ID = ?";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {

                int productId = id;
                String name = rs.getString("name");
                String code = rs.getString("code");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");

              /* System.out.println("userid : " + userid);
                System.out.println("username : " + username);*/

                product6.setId(productId);
                product6.setName(name);
                product6.setCode(code);
                product6.setPrice(price);
                product6.setStock(stock);

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

        return product6;
    }

    @Override
    public void updateProduct(double price, int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE products SET price = ? WHERE ID = ?";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {
            preparedStmt.setDouble(1, 1000);
            preparedStmt.setInt(2,id);

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

    @Override
    public void deleteProduct(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = " delete from products where id= ? ";

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
