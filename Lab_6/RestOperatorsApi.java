package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Service.OperatorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operatorApi/requests")

public class RestOperatorsApi {
    private final OperatorsService service;

    @GetMapping
    public ResponseEntity<?> getAllOperators(){
        return new ResponseEntity<>(service.getAllOperators(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Operators operators){
        service.saveOperator(operators);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOperator(@PathVariable String id){
        service.deleteOperator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
