package com.shopping.utils;

import com.shopping.domain.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nainadhanwani on 2/3/17.
 */
public class ProductRead {
    public  static List<Product> ProductRead() throws IOException{
       File file2 = new File("/Users/nainadhanwani/projects/ShoppingCart/src/com/shopping/ProductReadFile") ;
        FileReader fileReader = new FileReader(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data1;
        List<Product> productList = new ArrayList <>();
        while((data1=bufferedReader.readLine()) != null){
            String splitdata[] = data1.split(",");
            int i =0;
            Product product = new Product();
            product.setName(splitdata[i]);
            product.setCode(splitdata[++i]);
            product.setPrice(Double.parseDouble(splitdata[++i]));
            product.setStock(Integer.parseInt(splitdata[++i]));
            productList.add(product);
        }
            return productList;
    }
}
