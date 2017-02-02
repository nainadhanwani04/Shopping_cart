package com.shopping.service;

import com.shopping.client.UserClient;
import com.shopping.domain.User;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public interface UserService {

    public void addUser(User user) throws SQLException;

    public void deleteUser(int id);

    public void fetchUser(int id);

    public void updateUser(String userName,int id);

    public User readUser(int id);
}
