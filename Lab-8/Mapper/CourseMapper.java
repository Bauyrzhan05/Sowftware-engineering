package com.example.demo.Lab_8.Mapper;

import com.example.demo.Lab_8.Dto.CourseDto;
import com.example.demo.Lab_8.Model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto courseDto);

    List<CourseDto> toDtoList(List<Course> courses);
}
