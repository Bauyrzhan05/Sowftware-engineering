package com.example.demo.Lab_8.Repository;

import com.example.demo.Lab_8.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
