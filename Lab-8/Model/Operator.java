package com.example.demo.Lab_8.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operators")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator {
    @Id
    private String id;
    private String name;
    private String surname;
    private String department;
}
