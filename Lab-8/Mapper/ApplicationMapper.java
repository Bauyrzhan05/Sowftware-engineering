package com.example.demo.Lab_8.Mapper;

import com.example.demo.Lab_8.Dto.ApplicationDto;
import com.example.demo.Lab_8.Model.Application;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDto toDto(Application application);
    Application toEntity(ApplicationDto applicationDto);

    List<ApplicationDto> toDtoList(List<Application> applications);
}
