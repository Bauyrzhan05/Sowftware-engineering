package com.example.demo.Lab_8.Controller;

import com.example.demo.Lab_8.Dto.ApplicationDto;
import com.example.demo.Lab_8.Service.ApplicationService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(applicationService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(applicationService.add(applicationDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ApplicationDto applicationDto){
        return new ResponseEntity<>(applicationService.update(id, applicationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return new ResponseEntity<>(applicationService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/assign/{appId}")
    public ResponseEntity<?> assignOperators(@PathVariable String appId, @RequestBody List<String> operatorIds){
        return new ResponseEntity<>(applicationService.assignOperators(appId, operatorIds), HttpStatus.OK);
    }
}
