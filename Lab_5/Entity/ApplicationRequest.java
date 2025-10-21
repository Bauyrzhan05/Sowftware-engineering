package com.example.demo.Lab_5.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "application_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    @Id
    private String id;
    private String userName;
    private String commentary;
    private String phone;
    private boolean handled = false;

    private Courses course; // Бір өтініш тек бір курсқа қатысты

    private List<Operators> operators; // Бір өтінішті бірнеше оператор өңдей алады
}
