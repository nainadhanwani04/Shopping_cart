package com.shopping.utils;

import com.shopping.domain.Order;
import com.shopping.domain.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nainadhanwani on 2/3/17.
 */
public class OrderRead {
    public  static List<Order> OrderRead() throws IOException {
        File file2 = new File("/Users/nainadhanwani/projects/ShoppingCart/src/com/shopping/OrderRead") ;
        FileReader fileReader = new FileReader(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data1;
        List<Order> orderList = new ArrayList<>();
        while((data1=bufferedReader.readLine()) != null){
            String splitdata[] = data1.split(",");
            int i =0;
           // Product product = new Product();
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setAmount(Double.parseDouble(splitdata[i]));
            order.setUserId(Integer.parseInt(splitdata[++i]));
            orderList.add(order);
        }
        return orderList;
    }
}
