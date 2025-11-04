package com.example.demo.Lab_7.Dto;

import lombok.*;

@Getter
@Setter
@Builder
public class FoodDto {
    String id;
    String name;
    String description;
    int price;
}
