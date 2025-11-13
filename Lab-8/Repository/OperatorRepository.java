package com.example.demo.Lab_8.Repository;

import com.example.demo.Lab_8.Model.Operator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperatorRepository extends MongoRepository<Operator, String> {
}
