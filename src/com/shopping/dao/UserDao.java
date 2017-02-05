package com.shopping.dao;

import com.shopping.domain.User;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/27/17.
 */
public interface UserDao {

public void createUser(User user) throws Exception;

public User readUser(int id) throws SQLException;

public void updateUser(User user,int id) throws SQLException;

public void deleteUser(int id) throws SQLException;
}
