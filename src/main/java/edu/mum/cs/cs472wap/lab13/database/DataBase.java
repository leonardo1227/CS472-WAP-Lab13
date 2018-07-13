package edu.mum.cs.cs472wap.lab13.database;

import edu.mum.cs.cs472wap.lab13.model.Order;
import edu.mum.cs.cs472wap.lab13.model.Product;
import edu.mum.cs.cs472wap.lab13.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {

    private static String IMAGES_PATH = "../resource/image/";

    public static HashMap<String, User> users;

    public static List<Order> orders;

   public static HashMap<Integer, Product> produtcs;
    static {
        produtcs = new HashMap<>();
        produtcs.put(1,new Product(1,"Men's Sunglasses 1", 50.0,IMAGES_PATH+"product/1.jpg"));
        produtcs.put(2,new Product(2,"Men's Sunglasses 2", 45.0,IMAGES_PATH+"product/2.jpg"));
        produtcs.put(3,new Product(3,"Men's Sunglasses 3", 70.0,IMAGES_PATH+"product/3.jpg"));
        produtcs.put(4,new Product(4,"Men's Sunglasses 4", 35.0,IMAGES_PATH+"product/4.jpg"));
        produtcs.put(5,new Product(5,"Men's Watch 1", 85.0,IMAGES_PATH+"product/5.jpg"));
        produtcs.put(6,new Product(6,"Men's Watch 2", 95.0,IMAGES_PATH+"product/6.jpg"));
        produtcs.put(7,new Product(7,"Men's Watch 3", 65.0,IMAGES_PATH+"product/7.jpg"));
        produtcs.put(8,new Product(8,"Men's Watch 4", 105.0,IMAGES_PATH+"product/8.jpg"));
        produtcs.put(9,new Product(9,"Men's Perfume 1", 40.0,IMAGES_PATH+"product/9.jpg"));
        produtcs.put(10,new Product(10,"Men's Perfume 2", 30.0,IMAGES_PATH+"product/10.jpg"));
        produtcs.put(11,new Product(11,"Men's Perfume 3", 50.0,IMAGES_PATH+"product/11.jpg"));
        produtcs.put(12,new Product(12,"Men's Perfume 4", 20.0,IMAGES_PATH+"product/12.jpg"));
        produtcs.put(13,new Product(13,"Men's Shirt 1", 40.0,IMAGES_PATH+"product/13.jpg"));
        produtcs.put(14,new Product(14,"Men's Shirt 2", 25.0,IMAGES_PATH+"product/14.jpg"));
        produtcs.put(15,new Product(15,"Men's Shirt 3", 45.0,IMAGES_PATH+"product/15.jpg"));

        users = new HashMap<>();
        users.put("leonardostc", new User("Leonardo Samuel Tolosa Contreras", "leonardostc", "123456"));

        orders = new ArrayList<>();
    }
}
