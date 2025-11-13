package com.example.demo.Lab_8.Service;

import com.example.demo.Lab_8.Dto.OperatorDto;

import java.util.List;

public interface OperatorService {
    List<OperatorDto> getAll();
    OperatorDto add(OperatorDto operatorDto);
    OperatorDto update(String id, OperatorDto operatorDto);
    boolean delete(String id);
}
