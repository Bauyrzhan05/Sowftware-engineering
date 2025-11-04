package com.example.demo.Lab_7.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foods")
@Getter
@Setter
public class Food {
    @Id
    String id;
    String name;
    String description;
    int price;
}
