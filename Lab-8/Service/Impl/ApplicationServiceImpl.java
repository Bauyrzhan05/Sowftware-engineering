package com.example.demo.Lab_8.Service.Impl;

import com.example.demo.Lab_8.Dto.ApplicationDto;
import com.example.demo.Lab_8.Mapper.ApplicationMapper;
import com.example.demo.Lab_8.Model.Application;
import com.example.demo.Lab_8.Model.Operator;
import com.example.demo.Lab_8.Repository.ApplicationRepository;
import com.example.demo.Lab_8.Repository.OperatorRepository;
import com.example.demo.Lab_8.Service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    ApplicationRepository applicationRepository;
    OperatorRepository operatorRepository;
    ApplicationMapper applicationMapper;

    @Override
    public List<ApplicationDto> getAll() {
        return applicationMapper.toDtoList(applicationRepository.findAll());
    }

    @Override
    public ApplicationDto add(ApplicationDto applicationDto) {
        return applicationMapper.toDto(applicationRepository.save(applicationMapper.toEntity(applicationDto)));
    }

    @Override
    public ApplicationDto update(String id, ApplicationDto applicationDto) {
        Application application = applicationRepository.findById(id).orElseThrow();

        application.setUserName(applicationDto.getUserName());
        application.setPhone(application.getPhone());
        application.setCourse(application.getCourse());
        application.setOperators(applicationDto.getOperators());

        return applicationMapper.toDto(applicationRepository.save(application));
    }

    @Override
    public boolean delete(String id) {
        applicationRepository.deleteById(id);
        return true;
    }

    @Override
    public ApplicationDto assignOperators(String appId, List<String> operatorIds) {
        Application application = applicationRepository.findById(appId).orElseThrow();
        List<Operator> operators = new ArrayList<>();

        for (String opId: operatorIds){
            Operator op = operatorRepository.findById(opId).orElseThrow();
            operators.add(op);
        }
        application.setOperators(operators);

        return applicationMapper.toDto(applicationRepository.save(application));
    }
    
}
