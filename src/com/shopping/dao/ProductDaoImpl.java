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
        String query = " insert into products (name,code,price, stock)"
                + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

       // preparedStmt.setInt(1, product.getId());
        preparedStmt.setString(1,product.getName() );
        preparedStmt.setString(2, product.getCode());
        preparedStmt.setDouble(3, product.getPrice());
        preparedStmt.setInt(4, product.getStock());

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
    public void updateProduct(Product product, int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE products SET name = ?, code = ?, price = ? ,stock = ? WHERE ID = ?";

        Product product1 = readProduct(id);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        try {
            if ( product.getName() != null )
                preparedStmt.setString(1, product.getName());
            else
                preparedStmt.setString(1, product1.getName());
            if ( product.getCode() != null )
                preparedStmt.setString(2, product.getCode());
            else
                preparedStmt.setString(2, product1.getCode());
            if ( product.getPrice() != product1.getPrice() )
                preparedStmt.setDouble(3, product.getPrice());
            else
                preparedStmt.setDouble(3, product1.getPrice());
            if ( product.getStock() != product1.getStock() )
                preparedStmt.setInt(4, product.getStock());
            else
                preparedStmt.setInt(4, product1.getStock());

            preparedStmt.setInt(5, id);

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
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
