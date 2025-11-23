package com.example.demo.Lab_9.Controller;

import com.example.demo.Lab_9.Dto.CountryDto;
import com.example.demo.Lab_9.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CountryDto countryDto){
        return new ResponseEntity<>(countryService.add(countryDto), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CountryDto countryDto){
        return new ResponseEntity<>(countryService.update(id, countryDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(countryService.delete(id), HttpStatus.OK);
    }

}
