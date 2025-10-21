package com.example.demo.Lab_5.Repository;

import com.example.demo.Lab_5.Entity.Operators;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OperatorsRepository extends MongoRepository<Operators, String> {
    List<Operators> findByDepartment(String department);
}
