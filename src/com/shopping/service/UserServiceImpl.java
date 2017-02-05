package com.shopping.service;

import com.shopping.dao.UserDaoImpl;
import com.shopping.domain.User;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) throws SQLException,Exception {
        UserDaoImpl userDao = new UserDaoImpl();
            userDao.createUser(user);
          //  System.err.println("Normal message");
    }

    @Override
    public void deleteUser(int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            userDao.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchUser(int id) {
        User user9 = readUser(id);
        if(user9 != null) {
            System.out.println(user9.getId());
            System.out.println(user9.getUserName());
            System.out.println(user9.getFirstName());
            System.out.println(user9.getLastName());
            System.out.println(user9.getAddress());
        }
    }

    @Override
    public void updateUser(User user,int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        try {
           userDao.updateUser(user,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // return user;
    }

    @Override
    public User readUser(int id) {
        UserDaoImpl userDaoImp = new UserDaoImpl();
        User user = new User();
        try {
            user= userDaoImp.readUser(id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }
}


