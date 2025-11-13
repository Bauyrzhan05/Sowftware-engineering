package com.example.demo.Lab_8.Service;

import com.example.demo.Lab_8.Dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto add(CourseDto courseDto);
    CourseDto update(String id, CourseDto courseDto);
    boolean delete(String id);
}
