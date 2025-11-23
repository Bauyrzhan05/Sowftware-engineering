package com.example.demo.Lab_9.Service;

import com.example.demo.Lab_9.Dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto add(CountryDto countryDto);
    CountryDto update(Long id, CountryDto countryDto);
    boolean delete(Long id);
}
