package com.example.demo.Lab_5.Repository;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppRequestRepository extends MongoRepository<ApplicationRequest, String> {
    List<ApplicationRequest> findByHandled(boolean handled);
}
