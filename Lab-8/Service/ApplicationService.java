package com.example.demo.Lab_8.Service;

import com.example.demo.Lab_8.Dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> getAll();
    ApplicationDto add(ApplicationDto applicationDto);
    ApplicationDto update(String id, ApplicationDto applicationDto);
    boolean delete(String id);
    ApplicationDto assignOperators(String appId, List<String> operatorIds);
}
