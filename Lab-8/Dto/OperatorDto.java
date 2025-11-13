package com.example.demo.Lab_8.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperatorDto {
    private String id;
    private String name;
    private String surname;
    private String department;
}
