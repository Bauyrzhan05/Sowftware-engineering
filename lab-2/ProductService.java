package com.example.demo.Lab_2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Items> products = new ArrayList<>();

    public ProductService(){
        products.add(new Items(1L, "Salad", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 20.12));
        products.add(new Items(2L, "Fish", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 11.2 ));
        products.add(new Items(3L, "Hamburger", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 16.5));
        products.add(new Items(4L, "Pizza", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 12.14 ));
        products.add(new Items(5L, "Sandwich", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 18.2 ));
        products.add(new Items(6L, "Burger", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer", 10.13 ));
    }

    public List<Items> getAll(){
        return products;
    }

}
