package com.example.demo.Lab_9.Dto;

import com.example.demo.Lab_9.Model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private CountryDto manufacturer;
}
