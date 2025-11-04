package com.example.demo.Lab_7.Controller;

import com.example.demo.Lab_7.Dto.FoodDto;
import com.example.demo.Lab_7.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<?> getFoods(){
        return new ResponseEntity<>(foodService.getFoods(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFood(@PathVariable String id){
        FoodDto foodDto = foodService.getFood(id);

        if (Objects.isNull(foodDto)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } return ResponseEntity.ok(foodDto);
    }

    @PostMapping()
    public ResponseEntity<?> addFood(@RequestBody FoodDto foodDto){
        return new ResponseEntity<>(foodService.addFood(foodDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFood(@PathVariable String id, @RequestBody FoodDto foodDto){
        FoodDto updatedFoodDto = foodService.updateFood(id, foodDto);
        if (Objects.isNull(updatedFoodDto)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } return ResponseEntity.ok(updatedFoodDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable String id){
        return new ResponseEntity<>(foodService.deleteFood(id), HttpStatus.OK);
    }
}
