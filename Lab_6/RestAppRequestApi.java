package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import com.example.demo.Lab_5.Service.AppRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appApi/requests")
public class RestAppRequestApi {
    private final AppRequestService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAllApplicationRequests(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return new ResponseEntity<>(service.getApplicationRequestById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ApplicationRequest request){
        service.saveApplicationRequest(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable String id, @RequestBody ApplicationRequest request){
        service.updateApplicationRequest(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        service.deleteApplicationRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/assign/{requestId}")
    public ResponseEntity<?> assignOperatorsToRequest(@PathVariable String requestId, @RequestBody List<String> operatorIds){
        service.assignOperatorsToRequest(requestId, operatorIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
