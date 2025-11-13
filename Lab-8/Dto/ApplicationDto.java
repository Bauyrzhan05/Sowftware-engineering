package com.example.demo.Lab_8.Dto;

import com.example.demo.Lab_8.Model.Course;
import com.example.demo.Lab_8.Model.Operator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    String id;
    String userName;
    String phone;
    Course course;
    List<Operator> operators;
}
