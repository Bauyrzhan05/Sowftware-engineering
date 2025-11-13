package com.example.demo.Lab_8.Controller;

import com.example.demo.Lab_8.Dto.OperatorDto;
import com.example.demo.Lab_8.Service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operator")
public class OperatorController {
    private final OperatorService operatorService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(operatorService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OperatorDto operatorDto){
        return new ResponseEntity<>(operatorService.add(operatorDto), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> add(@PathVariable String id, @RequestBody OperatorDto operatorDto){
        return new ResponseEntity<>(operatorService.update(id, operatorDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> add(@PathVariable String id){
        return new ResponseEntity<>(operatorService.delete(id), HttpStatus.OK);
    }


}
