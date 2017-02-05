package com.shopping.utils;

import com.shopping.domain.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nainadhanwani on 2/3/17.
 */
public class UserRead {
        public  static List<User> UserRead() throws IOException {
            File file2 = new File("/Users/nainadhanwani/projects/ShoppingCart/src/com/shopping/UserRead") ;
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data1;
            List<User> userList = new ArrayList<>();
            while((data1=bufferedReader.readLine()) != null){
                String splitdata[] = data1.split(",");
                int i =0;
              //Product product = new Product();
                User user = new User();
                user.setUserName(splitdata[i]);
                user.setFirstName(splitdata[++i]);
                user.setLastName((splitdata[++i]));
                user.setAddress((splitdata[++i]));
                userList.add(user);
            }
            return userList;
        }
}
