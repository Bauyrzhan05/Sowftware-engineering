package com.example.demo.Lab_8.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    String id;
    String name;
    String description;
    int price;
}
