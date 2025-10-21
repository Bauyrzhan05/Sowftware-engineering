package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.ApplicationRequest;
import com.example.demo.Lab_5.Entity.Courses;
import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Service.AppRequestService;
import com.example.demo.Lab_5.Service.CoursesService;
import com.example.demo.Lab_5.Service.OperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppRequestController {

    @Autowired
    private AppRequestService appRequestService;

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private OperatorsService operatorsService;

    @GetMapping("/")
    public String getAllApplications(Model model) {
        model.addAttribute("applications", appRequestService.getAllApplicationRequests());
        return "Lab-5/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("application", new ApplicationRequest());
        model.addAttribute("courses", coursesService.getAllCourses());
        return "Lab-5/add-request";
    }

    @PostMapping("/add")
    public String addApp(@ModelAttribute ApplicationRequest application,
                         @RequestParam String courseId) {
        Courses course = coursesService.getCourseById(courseId);
        application.setCourse(course);
        appRequestService.saveApplicationRequest(application);
        return "redirect:/requests/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        ApplicationRequest application = appRequestService.getApplicationRequestById(id);
        model.addAttribute("application", application);
        model.addAttribute("courses", coursesService.getAllCourses());
        return "Lab-5/edit-request";
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

    @GetMapping("/{id}")
    public String viewApp(@PathVariable String id, Model model) {
        ApplicationRequest application = appRequestService.getApplicationRequestById(id);
        model.addAttribute("app", application);
        return "Lab-5/request-detail";
    }

    @GetMapping("/process/{id}")
    public String showProcessForm(@PathVariable String id, Model model) {
        ApplicationRequest application = appRequestService.getApplicationRequestById(id);
        List<Operators> allOperators = operatorsService.getAllOperators();
        model.addAttribute("app", application);
        model.addAttribute("operators", allOperators);
        return "Lab-5/process-request";
    }

    @PostMapping("/assign/{id}")
    public String assignOperators(@PathVariable String id,
                                  @RequestParam List<String> operatorIds) {
        appRequestService.assignOperatorsToRequest(id, operatorIds);
        return "redirect:/" + id;
    }

    @PostMapping("/remove-operator/{requestId}/{operatorId}")
    public String removeOperator(@PathVariable String requestId,
                                 @PathVariable String operatorId) {
        appRequestService.removeOperatorFromRequest(requestId, operatorId);
        return "redirect:/requests/" + requestId;
    }

    @PostMapping("/delete/{id}")
    public String deleteApp(@PathVariable String id) {
        appRequestService.deleteApplicationRequest(id);
        return "redirect:/requests/";
    }

    @GetMapping("/pending")
    public String getPending(Model model) {
        model.addAttribute("applications", appRequestService.getPendingRequests());
        return "Lab-5/index";
    }

    @GetMapping("/processed")
    public String getProcessed(Model model) {
        model.addAttribute("applications", appRequestService.getProcessedRequests());
        return "Lab-5/index";
    }
}
