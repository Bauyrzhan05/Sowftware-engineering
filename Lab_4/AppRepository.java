package com.example.demo.Lab_4;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppRepository extends MongoRepository<Application, String> {
    List<Application> findByHandled(boolean handled);
}
