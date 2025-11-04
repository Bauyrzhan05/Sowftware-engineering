package com.example.demo.Lab_7.Repository;

import com.example.demo.Lab_7.Entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
