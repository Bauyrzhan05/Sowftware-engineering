package com.example.demo.Lab_5.Repository;

import com.example.demo.Lab_5.Entity.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoursesRepository extends MongoRepository<Courses, String> {
}
