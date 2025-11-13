package com.example.demo.Lab_8.Repository;

import com.example.demo.Lab_8.Model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application, String> {
}
