package com.example.demo.Lab_9.Service.Impl;

import com.example.demo.Lab_9.Dto.CountryDto;
import com.example.demo.Lab_9.Mapper.CountryMapper;
import com.example.demo.Lab_9.Model.Country;
import com.example.demo.Lab_9.Repository.CountryRepository;
import com.example.demo.Lab_9.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    @Override
    public List<CountryDto> getAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    public CountryDto add(CountryDto countryDto) {

        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto update(Long id, CountryDto countryDto) {
        Country country = countryRepository.findById(id).orElseThrow();

        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());

        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public boolean delete(Long id) {
        countryRepository.deleteById(id);
        return true;
    }
}
