package com.example.demo.Lab_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppController {

    @Autowired
    private AppRepository appRepository;

    @GetMapping("/")
    public String getAllApplications(Model model){
        model.addAttribute("applications", appRepository.findAll());
        return "Lab-4/index";
    }

    @GetMapping("/new")
    public String showAddForm(){
        return "Lab-4/add-app";
    }
    @PostMapping("/add")
    public String addApp(@ModelAttribute Application app){
        appRepository.save(app);
        return"redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model){
        Application app = appRepository.findById(id).orElse(null);
        model.addAttribute("application", app);
        return "Lab-4/edit-app";
    }
    @PostMapping("/{id}/update")
    public String updateApp(@PathVariable String id, @ModelAttribute Application updatedApp){
        Application app = appRepository.findById(id).orElse(null);
        if (app != null){
            app.setUserName(updatedApp.getUserName());
            app.setCourseName(updatedApp.getCourseName());
            app.setCommentary(updatedApp.getCommentary());
            app.setPhoneNumber(updatedApp.getPhoneNumber());
            appRepository.save(app);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String viewApp(@PathVariable String id, Model model){
        Application app = appRepository.findById(id).orElse(null);
        model.addAttribute("app", app);
        return "Lab-4/app-detail";
    }

    @PostMapping("/{id}/process")
    public String processApp(@PathVariable String id){
        Application app = appRepository.findById(id).orElse(null);
        if (app != null){
            app.setHandled(true);
            appRepository.save(app);
        }
        return "redirect:/" + id;
    }

    @PostMapping("{id}/delete")
    public String deleteApp(@PathVariable String id){
        appRepository.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/pending")
    public String getPending(Model model) {
        model.addAttribute("applications", appRepository.findByHandled(false));
        return "Lab-4/index";
    }

    @GetMapping("/processed")
    public String getProcessed(Model model) {
        model.addAttribute("applications", appRepository.findByHandled(true));
        return "Lab-4/index";
    }
}
