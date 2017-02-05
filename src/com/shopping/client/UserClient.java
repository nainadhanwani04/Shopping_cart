package com.shopping.client;

import com.shopping.domain.User;
import com.shopping.service.UserServiceImpl;
import com.shopping.utils.UserRead;

import java.util.List;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class UserClient {

    public static void main(String[] args) {                                           //Method1
        User user10 = User.createUser("Shei4", "Shela", "Dubey", "Luer ganj");
        User user11 = User.createUser("Maina", "Meila", "Chaubey", "Lekkker ganj");
        User user12 = User.UpdateUser("Maina1", "Chaey", "Leer ganj");
        User user9 = User.UpdateUser("Nana", "Dhanwan", "200 luker ");
        UserServiceImpl userService1 = new UserServiceImpl();

        try {
            userService1.addUser(user10);
            userService1.addUser(user11);
            userService1.addUser(user12);


            userService1.deleteUser(4);
            UserServiceImpl userService2 = new UserServiceImpl();
            userService1.updateUser(user9, 2);
            UserServiceImpl userService3 = new UserServiceImpl();
            userService3.fetchUser(3);

                                                                                     //Extracting Data Using File
            UserRead userRead = new UserRead();
            List <User> userList = userRead.UserRead();
            for (User user : userList) {
                UserServiceImpl userService = new UserServiceImpl();
                userService.addUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
