package com.example.demo.Lab_7.Service;


import com.example.demo.Lab_7.Dto.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> getFoods();
    FoodDto getFood(String id);
    FoodDto addFood(FoodDto foodDto);
    FoodDto updateFood(String id, FoodDto foodDto);
    boolean deleteFood(String id);
}
