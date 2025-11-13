package com.example.demo.Lab_8.Mapper;

import com.example.demo.Lab_8.Dto.OperatorDto;
import com.example.demo.Lab_8.Model.Operator;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperatorMapper {
    OperatorDto toDto(Operator operator);
    Operator toEntity(OperatorDto operatorDto);

    List<OperatorDto> toDtoList(List<Operator> operators);
}
