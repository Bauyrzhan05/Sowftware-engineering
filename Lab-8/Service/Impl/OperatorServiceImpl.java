package com.example.demo.Lab_8.Service.Impl;

import com.example.demo.Lab_8.Dto.OperatorDto;
import com.example.demo.Lab_8.Mapper.OperatorMapper;
import com.example.demo.Lab_8.Model.Operator;
import com.example.demo.Lab_8.Repository.OperatorRepository;
import com.example.demo.Lab_8.Service.OperatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OperatorServiceImpl implements OperatorService {
    OperatorRepository operatorRepository;
    OperatorMapper operatorMapper;

    @Override
    public List<OperatorDto> getAll() {
        return operatorMapper.toDtoList(operatorRepository.findAll());
    }

    @Override
    public OperatorDto add(OperatorDto operatorDto) {
        return operatorMapper.toDto(operatorRepository.save(operatorMapper.toEntity(operatorDto)));
    }

    @Override
    public OperatorDto update(String id, OperatorDto operatorDto) {
        Operator operator = operatorRepository.findById(id).orElseThrow();

        operator.setDepartment(operatorDto.getDepartment());
        operator.setName(operatorDto.getName());
        operator.setSurname(operatorDto.getSurname());
        return operatorMapper.toDto(operator);
    }

    @Override
    public boolean delete(String id) {
        operatorRepository.deleteById(id);
        return true;
    }
}
