package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Service.OperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operators")
public class OperatorsController {

    @Autowired
    private OperatorsService operatorsService;

    @GetMapping
    public String getAllOperators(Model model) {
        model.addAttribute("operators", operatorsService.getAllOperators());
        return "Lab-5/operators/index";
    }

    @GetMapping("/new")
    public String showAddForm() {
        return "Lab-5/operators/add-operator";
    }

    @PostMapping("/add")
    public String addOperator(@ModelAttribute Operators operator) {
        operatorsService.saveOperator(operator);
        return "redirect:/operators";
    }

    @PostMapping("/delete/{id}")
    public String deleteOperator(@PathVariable String id) {
        operatorsService.deleteOperator(id);
        return "redirect:/operators";
    }

}
