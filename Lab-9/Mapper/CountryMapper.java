package com.example.demo.Lab_9.Mapper;

import com.example.demo.Lab_9.Dto.CountryDto;
import com.example.demo.Lab_9.Model.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);
    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);
}
