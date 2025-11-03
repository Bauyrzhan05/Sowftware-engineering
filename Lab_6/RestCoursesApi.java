package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.Courses;
import com.example.demo.Lab_5.Service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseApi/requests")
public class RestCoursesApi {
    private final CoursesService service;

    @GetMapping
    public ResponseEntity<?> getAllCourses(){
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable String id){
        return new ResponseEntity<>(service.getCourseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Courses courses){
        return new ResponseEntity<>(service.saveCourse(courses), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        service.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
