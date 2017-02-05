package com.shopping.utils;

import com.shopping.domain.OrderDetail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nainadhanwani on 2/3/17.
 */
public class OrderDetailsRead {

    public static List <OrderDetail> OrderDetailRead() throws IOException {
        File file1 = new File("/Users/nainadhanwani/projects/ShoppingCart/src/com/shopping/OrderDetails");
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data;
        List <OrderDetail> orderDetailList = new ArrayList <>();
        while ((data = bufferedReader.readLine()) != null) {
            String splitData[] = data.split(",");
            int i = 0;
                OrderDetail orderDetail = new OrderDetail();
              //  orderDetail.setId(Integer.parseInt(splitData[i]));
                orderDetail.setOrderId(Integer.parseInt(splitData[i]));
                orderDetail.setProductId(Integer.parseInt(splitData[++i]));
                orderDetail.setQuantity(Integer.parseInt(splitData[++i]));
                orderDetail.setPrice(Double.parseDouble(splitData[++i]));
                orderDetail.setAmount(Double.parseDouble(splitData[++i]));
                orderDetailList.add(orderDetail);
            }
        return orderDetailList;
        }

    }


/*
    public static void main(String[] args) {
       // OrderDetailsRead orderDetailRead = new OrderDetailsRead();
        try {
            OrderDetailRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/