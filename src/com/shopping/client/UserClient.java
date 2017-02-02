package com.shopping.client;

import com.shopping.domain.User;
import com.shopping.service.UserServiceImpl;

import java.sql.SQLException;

/**
 * Created by nainadhanwani on 1/29/17.
 */
public class UserClient {

    public static void main(String[] args) {
     User user1=User.createUser(1,"Sheila04","Sheila","Dubey","Luker ganj");
      User user2=User.createUser(2,"Meila01","Meila","Chaubey","Lekkker ganj");
      User user3=User.createUser(3,"Meia01","ila","Chaey","Leer ganj");

       UserServiceImpl userService1 = new UserServiceImpl();
        try {
            userService1.addUser(user1);
            userService1.addUser(user2);
            userService1.addUser(user3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userService1.deleteUser(3);
       // UserServiceImpl userService2 = new UserServiceImpl();
        userService1.updateUser("Puja",2);
        //UserServiceImpl userService1 = new UserServiceImpl();
        userService1.fetchUser(1);




    }
}
