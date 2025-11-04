package com.example.demo.Lab_7.Service;

import com.example.demo.Lab_7.Dto.FoodDto;
import com.example.demo.Lab_7.Entity.Food;

import com.example.demo.Lab_7.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public List<FoodDto> getFoods() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDto> foodDtos = new ArrayList<>();

        foods.forEach(food -> {
            FoodDto dto = toDto(food);
            foodDtos.add(dto);
        });
        return foodDtos;
    }

    public FoodDto getFood(String id) {
        Food food = foodRepository.findById(id).orElse(null);

        if (Objects.isNull(food)){
            return null;
        }
        return toDto(food);
    }

    public FoodDto addFood(FoodDto foodDto) {
        Food food = foodRepository.save(toEntity(foodDto));
        return toDto(food);
    }

    public FoodDto updateFood(String id, FoodDto foodDto) {
        FoodDto checkFood = getFood(id);
        if (Objects.isNull(checkFood)){
            return null;
        }
        Food food = toEntity(foodDto);
        Food updatedFood = foodRepository.save(food);

        return toDto(updatedFood);
    }

    public boolean deleteFood(String id) {
        FoodDto checkFood = getFood(id);

        if (Objects.isNull(checkFood)){
            return false;
        }
        foodRepository.deleteById(id);

        return true;
    }

//    ===============Convert===================

    FoodDto toDto(Food food){
        return FoodDto
                .builder()
                .id(food.getId())
                .name(food.getName())
                .description(food.getDescription())
                .price(food.getPrice())
                .build();
    }

    Food toEntity(FoodDto foodDto){
        Food food = new Food();
        food.setId(foodDto.getId());
        food.setName(foodDto.getName());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());
        return food;
    }
}
