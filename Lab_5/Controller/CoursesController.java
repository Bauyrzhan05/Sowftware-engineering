package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import com.example.demo.Lab_5.Entity.Courses;
import com.example.demo.Lab_5.Service.AppRequestService;
import com.example.demo.Lab_5.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public String getAllCourses(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        return "Lab-5/courses/index";
    }

    @GetMapping("/new")
    public String showAddForm() {
        return "Lab-5/courses/add-course";
    }
    @PostMapping("/add")
    public String addCourse(@ModelAttribute Courses course) {
        coursesService.saveCourse(course);
        return "redirect:/courses";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
        return "redirect:/courses";
    }
}
