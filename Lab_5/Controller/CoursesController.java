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
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private AppRequestService appRequestService;

    @GetMapping("/")
    public String getAllCourses(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        return "Lab-5/courses/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Courses());
        return "Lab-5/courses/add-course";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Courses course) {
        coursesService.saveCourse(course);
        return "redirect:/courses/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Courses course = coursesService.getCourseById(id);
        model.addAttribute("course", course);
        return "Lab-5/courses/edit-course";
    }

    @PostMapping("/update/{id}")
    public String updateApp(@PathVariable String id,
                            @ModelAttribute ApplicationRequest updatedApp,
                            @RequestParam String courseId) {
        ApplicationRequest currentApp = appRequestService.getApplicationRequestById(id);
        if (currentApp != null) {
            Courses course = coursesService.getCourseById(courseId);
            currentApp.setUserName(updatedApp.getUserName());
            currentApp.setCommentary(updatedApp.getCommentary());
            currentApp.setPhone(updatedApp.getPhone());
            currentApp.setCourse(course);
            appRequestService.saveApplicationRequest(currentApp);
        }
        return "redirect:/requests/";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
        return "redirect:/courses/";
    }
}
