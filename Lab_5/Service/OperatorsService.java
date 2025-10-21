package com.example.demo.Lab_5.Service;


import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Repository.OperatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorsService {

    @Autowired
    private OperatorsRepository operatorsRepository;

    public List<Operators> getAllOperators() {
        return operatorsRepository.findAll();
    }

    public Operators getOperatorById(String id) {
        Optional<Operators> operator = operatorsRepository.findById(id);
        return operator.orElse(null);
    }

    public void saveOperator(Operators operator) {
        operatorsRepository.save(operator);
    }

    public void deleteOperator(String id) {
        operatorsRepository.deleteById(id);
    }

    public List<Operators> getOperatorsByDepartment(String department) {
        return operatorsRepository.findByDepartment(department);
    }

}
