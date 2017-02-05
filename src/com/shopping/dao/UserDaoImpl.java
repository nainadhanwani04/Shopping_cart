package com.shopping.dao;

import com.shopping.client.UserClient;
import com.shopping.domain.User;
import com.shopping.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 * Created by nainadhanwani on 1/29/17.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void createUser(User user) throws Exception {

        try {
            Connection con = DBConnection.getConnection();
            String query = " insert into users (user_name,first_name,last_name, address)"
                    + " values ( ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);

         //   preparedStmt.setInt(1, user.getId());
            preparedStmt.setString(1, user.getUserName());
            preparedStmt.setString(2, user.getFirstName());
            preparedStmt.setString(3, user.getLastName());
            preparedStmt.setString(4, user.getAddress());

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
    public User readUser(int id) throws SQLException {
        User user5 =new User();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM users WHERE ID = ?";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);

        try {

            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {

                int userid = id;
                String username = rs.getString("user_name");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String address = rs.getString("address");

                user5.setId(id);
                user5.setUserName(username);
                user5.setFirstName(firstname);
                user5.setLastName(lastname);
                user5.setAddress(address);

            }
            // execute the preparedstatement
            con.close();
        } catch (SQLException e) {
            System.err.println("Got an exception1!");
        } finally {
                preparedStmt.close();
                con.close();

        }

        return user5;
    }


    @Override
    public void updateUser(User user, int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE users SET user_name = ?, first_name= ?, last_name = ? ,address = ? WHERE ID = ?";
        //  String updateFirstName,updateLastName,updateUserName,updateAddress;
        // create the mysql insert preparedstatement
        //String query1 = "Select * from users where id= ?";
        User user1 = readUser(id);
        PreparedStatement preparedStmt = con.prepareStatement(query);
        try {
            if ( user.getUserName() != null )
                preparedStmt.setString(1, user.getUserName());
            else
                preparedStmt.setString(1, user1.getUserName());
            if ( user.getFirstName() != null )
                preparedStmt.setString(2, user.getFirstName());
            else
                preparedStmt.setString(2, user1.getFirstName());
            if ( user.getLastName() != null )
                preparedStmt.setString(3, user.getLastName());
            else
                preparedStmt.setString(3, user1.getLastName());
            if ( user.getAddress() != null )
                    preparedStmt.setString(4, user.getAddress());
            else
                preparedStmt.setString(4, user1.getAddress());

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
    public void deleteUser(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = " delete from users where id= ? ";

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

