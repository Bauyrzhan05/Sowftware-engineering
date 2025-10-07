package com.example.demo.Lab_3.Part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "Part1/index";
    }

    @GetMapping("/add")
    public String addForm() {
        return "Part1/add-student";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int exam) {
        studentService.addStudent(name, surname, exam);
        return "redirect:/";
    }
}
