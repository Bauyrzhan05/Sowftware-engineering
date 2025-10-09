package com.example.demo.Lab_4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    private String id;
    private String userName;
    private String courseName;
    private String commentary;
    private String phoneNumber;
    private boolean handled = false;
}
