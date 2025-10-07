package com.example.demo.Lab_3.Part1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<>();
    Long idCounter = 1L;

    public List<Student> getAllStudents(){
        return students;
    }

    String calculateMark(int exam){
        if (exam >= 90) return "A";
        else if (exam >= 75) return "B";
        else if (exam >= 60) return "C";
        else if (exam >= 50) return "D";
        else return "F";
    }

    public void addStudent(String name, String surname, int exam){
        Student student = new Student(idCounter++, name, surname, exam, calculateMark(exam));
        students.add(student);
    }


}
