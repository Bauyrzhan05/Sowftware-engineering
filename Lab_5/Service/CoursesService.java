package com.example.demo.Lab_5.Service;

import com.example.demo.Lab_5.Entity.Courses;
import com.example.demo.Lab_5.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses getCourseById(String id) {
        Optional<Courses> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    public Courses saveCourse(Courses course) {
        return coursesRepository.save(course);
    }

    public void deleteCourse(String id) {
        coursesRepository.deleteById(id);
    }
}
