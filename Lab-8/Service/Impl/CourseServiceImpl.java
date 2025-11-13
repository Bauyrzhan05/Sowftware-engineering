package com.example.demo.Lab_8.Service.Impl;

import com.example.demo.Lab_8.Dto.CourseDto;
import com.example.demo.Lab_8.Mapper.CourseMapper;
import com.example.demo.Lab_8.Model.Course;
import com.example.demo.Lab_8.Repository.CourseRepository;
import com.example.demo.Lab_8.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    CourseMapper courseMapper;

    @Override
    public List<CourseDto> getAll() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto add(CourseDto courseDto) {
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDto)));
    }

    @Override
    public CourseDto update(String id, CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow();

        course.setDescription(courseDto.getDescription());
        course.setName(courseDto.getName());
        course.setPrice(courseDto.getPrice());

        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public boolean delete(String id) {
        courseRepository.deleteById(id);
        return true;
    }
}
