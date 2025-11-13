package com.example.demo.Lab_8.Controller;

import com.example.demo.Lab_8.Dto.CourseDto;
import com.example.demo.Lab_8.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.add(courseDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.update(id, courseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return new ResponseEntity<>(courseService.delete(id), HttpStatus.OK);
    }
}
