package com.example.demo.Lab_8.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "application_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    String id;
    String userName;
    String phone;
    Course course;
    List<Operator> operators;
}
