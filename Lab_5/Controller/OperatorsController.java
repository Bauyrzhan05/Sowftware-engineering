package com.example.demo.Lab_5.Controller;

import com.example.demo.Lab_5.Entity.Operators;
import com.example.demo.Lab_5.Service.OperatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperatorsController {

    @Autowired
    private OperatorsService operatorsService;

    @GetMapping("/")
    public String getAllOperators(Model model) {
        model.addAttribute("operators", operatorsService.getAllOperators());
        return "Lab-5/operators/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("operator", new Operators());
        return "Lab-5/operators/add-operator";
    }

    @PostMapping("/add")
    public String addOperator(@ModelAttribute Operators operator) {
        operatorsService.saveOperator(operator);
        return "redirect:/operators/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Operators operator = operatorsService.getOperatorById(id);
        model.addAttribute("operator", operator);
        return "Lab-5/operators/edit-operator";
    }

    @PostMapping("/update/{id}")
    public String updateOperator(@PathVariable String id, @ModelAttribute Operators updatedOperator) {
        Operators currentOperator = operatorsService.getOperatorById(id);
        if (currentOperator != null) {
            currentOperator.setName(updatedOperator.getName());
            currentOperator.setSurname(updatedOperator.getSurname());
            currentOperator.setDepartment(updatedOperator.getDepartment());
            operatorsService.saveOperator(currentOperator);
        }
        return "redirect:/operators/";
    }

    @PostMapping("/delete/{id}")
    public String deleteOperator(@PathVariable String id) {
        operatorsService.deleteOperator(id);
        return "redirect:/operators/";
    }

    @GetMapping("/department/{department}")
    public String getByDepartment(@PathVariable String department, Model model) {
        model.addAttribute("operators", operatorsService.getOperatorsByDepartment(department));
        return "Lab-5/operators/index";
    }
}
